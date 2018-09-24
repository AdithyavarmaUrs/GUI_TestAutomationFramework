package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver = null;
	
	By signin = By.cssSelector("[href*='sign_in']");
	By title = By.xpath("//h2[contains(., 'Featured Courses')]");
	By navBar = By.xpath("//nav[@class='navbar-collapse collapse']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement clickSignin()
	{
		return driver.findElement(signin);		
	}
	public WebElement validateTitle()
	{
		return driver.findElement(title);
	}
	public WebElement validateNavigation()
	{
		return driver.findElement(navBar);
	}

}
