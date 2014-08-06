package argroupid.arartifactid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class postsPage {
	WebDriver driver;
	@FindBy(css="a.add-new-h2")
	WebElement addnewlink;
	
	public postsPage(WebDriver driver){
		this.driver= driver;
}
 public newPostPage gotoNewPost() throws Exception{
	 System.out.println("On Posts page");
	 //driver.findElement(By.cssSelector("a.add-new-h2")).click();
	 //return new newPostPage(driver);
	 addnewlink.click();
	 System.out.println("On new post page");
	 Thread.sleep(10);
	 return PageFactory.initElements(driver, newPostPage.class);
 }
}
