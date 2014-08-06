package argroupid.arartifactid;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import argroupid.arartifactid.Home;
import argroupid.arartifactid.LoginPage;
import argroupid.arartifactid.dashboardPage;
import argroupid.arartifactid.mySitesPage;
import argroupid.arartifactid.postsPage;

public class NewPost {
	  WebDriver driver;
	  LoginPage login;
	  Home home;
	  mySitesPage mysites;
	  dashboardPage dashboard;
	  postsPage posts;
	  newPostPage postspage;
	  private static Logger log = Logger.getLogger(NewPost.class);
	  
  @Test
  public void newpostcreate() throws Exception {
	  
	  DOMConfigurator.configure("log4j.xml");
 
	  //login = new LoginPage(driver);
	  login = PageFactory.initElements(driver, LoginPage.class);
	  log.info("I am logging in.");
	  home = login.validlogin("abhijeetrasal", "zodiac84");
	  
	  String samplelog = "I am now on :";
	  log.info(samplelog+"HOME.");
	  mysites = home.gotomySitesPage();
	  
	  try{
		  dashboard = mysites.gotoDashboard();  
	  }catch(NoSuchElementException e){
		  log.error("Some element was not found. Try again.",e);
	  }
	  
	  
	  posts = dashboard.gotoPosts();
	  postspage = posts.gotoNewPost();
 }
  @BeforeTest
  public void beforeTest() {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
