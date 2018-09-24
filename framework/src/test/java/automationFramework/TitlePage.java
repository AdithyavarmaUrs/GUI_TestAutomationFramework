package automationFramework;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.BrowserInvokation;

public class TitlePage  extends BrowserInvokation{
	
	public static Logger log = LogManager.getLogger(BrowserInvokation.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the HomePage");
	}
	
	@Test
		
	public void validateTitlePage() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		String actualText = l.validateTitle().getText();
		Assert.assertEquals(actualText, "FEATURED COURSES");
		log.info("Successfuly validated the expexted text");
		Assert.assertTrue(l.validateNavigation().isDisplayed());
	}	
	@AfterTest
	
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	}


}