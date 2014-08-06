package argroupid.arartifactid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mySitesPage {
	WebDriver driver;
	@FindBy(xpath="//*[text()='Dashboard']")
	WebElement dashboardlink;
	
	public mySitesPage(WebDriver driver){
		this.driver= driver;
	}
	
	public dashboardPage gotoDashboard(){
		System.out.println("On mySites page");
		//driver.findElement(By.xpath("//*[text()='Dashboard']")).click();
		//return new dashboardPage(driver);
		dashboardlink.click();
		return PageFactory.initElements(driver, dashboardPage.class);
	}
}
