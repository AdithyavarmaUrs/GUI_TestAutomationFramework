package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInvokation {
	
	public static WebDriver driver = null;
	public Properties prop =null;
	public FileInputStream fis = null;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream("C:\\Users\\Adithya Varma\\framework\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adithya Varma\\Documents\\ChromeDriver.exe");
			driver = new ChromeDriver();			
		}
		else if (browserName.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//IE code
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Adithya Varma\\testScreen\\"+result+"screenshot.png"));
		
	}
	

}
