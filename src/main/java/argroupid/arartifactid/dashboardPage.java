package argroupid.arartifactid;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage {
	WebDriver driver;
	@FindBy(xpath="//div[text()='Posts']")
	WebElement postsmenu;
	
	public dashboardPage(WebDriver driver){
		this.driver= driver;
}
	public postsPage gotoPosts(){
		Set<String> allWindows = driver.getWindowHandles();
		for(String curWindow : allWindows){
		    driver.switchTo().window(curWindow);
		}
		//driver.findElement(By.xpath("//div[text()='Posts']")).click();
		//return new postsPage(driver);
		System.out.println("Switched windows and now on Dashboard page");
		postsmenu.click();
		return PageFactory.initElements(driver, postsPage.class);
	}
}
