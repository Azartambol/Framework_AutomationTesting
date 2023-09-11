package com.store.Testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.strore.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc=new ReadConfig();
		String url=rc.getUrl();
	String browser=rc.getBrowser();
	WebDriver driver;
	Logger logg;
	String Email=rc.getEmail();
	String Pass=rc.getPass();
	@BeforeClass
	public void setup()
	{
		if(browser.toLowerCase().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	         driver=new ChromeDriver();
		}
		else if(browser.toLowerCase().equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else if(browser.toLowerCase().equals("edge"))
		{
			System.setProperty("webdriver.edge.driver","./Driver/msedgedriver.exe");
			 driver=new EdgeDriver();
		}
	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		logg=LogManager.getLogger("MyStore");
		
		logg.info("Browser Launched.........");
		driver.get(url);
		
		logg.info("Webpage Opened..........");
				
	}
	
	public void screenshotCapture(String testname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\DELL\\Desktop\\NewEverything\\MyStore\\ScreenShot\\"+testname+".png");
		FileUtils.copyFile(src, dest);
	}
	
	@AfterClass
     public void teardown()
   {
		 driver.close();
		driver.quit();
		
		logg.info("Browser Closed");
	}  
	

}
