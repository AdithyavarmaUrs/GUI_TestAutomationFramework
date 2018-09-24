package automationFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BrowserInvokation;

public class HomePage extends BrowserInvokation{
	public static Logger log = LogManager.getLogger(BrowserInvokation.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException
	{
		driver = initializeDriver();
	}
	@Test(dataProvider = "getData")
	
	public void validateAppNavigation(String userName, String password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.clickSignin().click();
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail().sendKeys(userName);
		lp.enterPassword().sendKeys(password);
		lp.clickLogin().click();
		log.info(text);
		lp.validateHome().click();
		log.info("Validated the navigation bar home link");
		
	}	
		@AfterTest
		
		public void closeBrowser()
		{
			driver.close();
			driver = null;
		}
	
	
	    @DataProvider
	    public Object[][] getData()
		{
			//Row stands for number of scenarios
			//Column stands for number of values to pass
			
			Object[][] data = new Object[2][3];
			data[0][0] = "addy@facebook.com";   //for ZEROth row
			data[0][1] = "0passw0rd";
			data[0][2] = "Non-Restricted User";
			
			data[1][0] = "abcd@orkut.com";
			data[1][1] = "1passw0rd";
			data[1][2] = "Restricted User";
			return data;
		}
	    
	    
	}


