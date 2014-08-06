package argroupid.arartifactid;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility 
{	
	WebDriver driver;
	PathType p;
	WebElement element;
	
	public Utility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static String getIdentifyMethod(String elementType)
		{
			String[] splitString = elementType.split("\\.");
			return splitString[1];
		}
	
	public WebElement getElement(String elementType, String elementName)
	{
		String path = getIdentifyMethod(elementType);
		p=PathType.valueOf(path);
		try
		{
			switch(p)
			{
			case id:
				element = driver.findElement(By.id(elementName));
			case xpath:
				element = driver.findElement(By.xpath(elementName));
			case css:
				element = driver.findElement(By.cssSelector(elementName));
			case name:
				element = driver.findElement(By.name(elementName));				
			}
		}catch(NoSuchElementException e){}
		return element;
	}
}
