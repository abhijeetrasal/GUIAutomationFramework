package argroupid.arartifactid;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="user_login")
	WebElement usrbox;
	@FindBy(id="user_pass")
	WebElement pwdbox;
	@FindBy(id="rememberme")
	WebElement remembercheckbox;
	@FindBy(id="wp-submit")
	WebElement submit;
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
	}
	
	public Home validlogin(String username,String password){
		System.out.println("On login page");
		/*driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("rememberme")).click();
		driver.findElement(By.id("wp-submit")).click();		
		return new Home(driver);*/
		usrbox.sendKeys(username);
		pwdbox.sendKeys(password);
		remembercheckbox.click();
		submit.click();
		return PageFactory.initElements(driver,Home.class);
	}

}
