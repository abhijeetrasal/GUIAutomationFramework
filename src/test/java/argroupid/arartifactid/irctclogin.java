package argroupid.arartifactid;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class irctclogin {
	WebDriver driver;
	Utility uti;
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
  public void firsttest() throws IOException
	{
	/*Login Test
	 * tester-
	 * date-
	 */
	Properties prop = new Properties();
	prop.load(new FileInputStream("./src/main/Object_Repository.properties"));
	uti = new Utility(driver);
	//String identifyMethod = Utility.getIdentifyMethod("pwd.id");
	
	String userId = prop.getProperty("userid.id");
	String userpass = prop.getProperty("pwd.id");
	String remme = prop.getProperty("remember.id");
	String login = prop.getProperty("login.id");	
	
	WebElement username = uti.getElement("user.id",userId);
	username.sendKeys("abhijeetrasal");
	WebElement pwd = uti.getElement("pwd.id", userpass);
	pwd.sendKeys("zodiac84");
	WebElement remember = uti.getElement("remember.id", remme);
	remember.click();
	WebElement loginbutton = uti.getElement("login.id", login);
	loginbutton.click();
	

	WebElement mySites = driver.findElement(By.cssSelector("html.js.no-touch body.logged-in.mp6.newdash.newdash-read header.toolbar.wpcom-masterbar.wpcom-header div.wpcom-navigation.site-navigation nav.wpcom-sections ul.sections-menu li.my-sites a"));
	mySites.click();

	String parentHandle = driver.getWindowHandle();
	
	WebElement dashboard = driver.findElement(By.xpath("//*[text()='Dashboard']"));
	dashboard.click();	

	Set<String> allWindows = driver.getWindowHandles();
	for(String curWindow : allWindows){
	    driver.switchTo().window(curWindow);
	}
	
	WebElement posts = driver.findElement(By.xpath("//div[text()='Posts']"));
	posts.click();
	
	WebElement addNew = driver.findElement(By.cssSelector("a.add-new-h2"));
	addNew.click();
  }
   @AfterTest
	public void tearDown()
	{
	   driver.quit();
	}
}
