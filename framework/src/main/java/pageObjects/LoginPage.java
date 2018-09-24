package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;		
	}

	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[id='user_password']");
	By logiBtn = By.cssSelector("[value='Log In']");
	By homeBtn = By.xpath("//a[contains(., 'Home')]");
	
	public WebElement enterEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement enterPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(logiBtn);
	}
	
	public WebElement validateHome()
	{ 
		return driver.findElement(homeBtn);
	}
	

	
}
