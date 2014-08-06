package argroupid.arartifactid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	@FindBy(css="html.js.no-touch body.logged-in.mp6.newdash.newdash-read header.toolbar.wpcom-masterbar.wpcom-header div.wpcom-navigation.site-navigation nav.wpcom-sections ul.sections-menu li.my-sites a")
	WebElement mySiteslink;
	
	public Home(WebDriver driver){
		this.driver= driver;
	}
	
	public mySitesPage gotomySitesPage(){
		System.out.println("On Home page");
		//driver.findElement(By.cssSelector("html.js.no-touch body.logged-in.mp6.newdash.newdash-read header.toolbar.wpcom-masterbar.wpcom-header div.wpcom-navigation.site-navigation nav.wpcom-sections ul.sections-menu li.my-sites a")).click();
		//return new mySitesPage(driver);
		mySiteslink.click();
		return PageFactory.initElements(driver, mySitesPage.class);
	}
}
