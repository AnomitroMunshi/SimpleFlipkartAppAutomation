package com.callhub.flipkart.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.callhub.flipkart.listeners.WebEventListener;
import com.callhub.flipkart.readproperties.ReadPropertyFile;
import com.callhub.flipkart.util.TestUtil;



public class Driver extends ReadPropertyFile {
	
	public static WebDriver driver=null;
	
		public Driver()
		{
			String browser=ReadPropertyFile.get("Browser");
			if(browser.equalsIgnoreCase("chrome")|| browser.toUpperCase().contains("CHROME"))
			{
				try{
					
					System.setProperty("webdriver.chrome.driver",OsPath.getPath(browser));
					driver=new ChromeDriver();
					
					//LogStatus.pass("Chrome drive launched with headless mode = "+headless.toUpperCase()+", Image Disable mode = "+imageDisable.toUpperCase());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			else if (browser.equalsIgnoreCase("FF")|| browser.toUpperCase().contains("FIRE")) 
			{
				try
				{
					
					System.setProperty("webdriver.gecko.driver",OsPath.getPath(browser));
							
					driver=new FirefoxDriver();
					//LogStatus.pass("FF drive launched with headless mode = "+headless.toUpperCase()+", Image Disable mode = "+imageDisable.toUpperCase());
						
				}
				catch(Exception e)
				{
					e.printStackTrace();
					//LogStatus.fail(e);
				}
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			EventHandlerInit();
			driver.get(ReadPropertyFile.get("url"));
			driver.manage().deleteAllCookies();
		}
		
		//Initializes browser instance
		public static void initialize()
		{
			new Driver();
		}
		//quits browser
		public static void quit()
		{
			driver.quit();
		}
		//initializes WebDriver EventListner
		public void EventHandlerInit()
		{
			EventFiringWebDriver eventHandle=new EventFiringWebDriver(driver);
			WebEventListener handler=new WebEventListener();
			eventHandle.register(handler);
			driver=eventHandle;
		}
		
		

}
