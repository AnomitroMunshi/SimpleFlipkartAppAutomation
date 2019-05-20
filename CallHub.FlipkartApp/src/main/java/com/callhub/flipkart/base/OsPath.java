package com.callhub.flipkart.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OsPath {
	
	public static Logger log=LogManager.getLogger(OsPath.class.getName());
	//Provide browser exe path based on OS
	public static String getPath(String browser) 
	{
		log.info("Browser to initialize="+browser);
		String OS=System.getProperty("os.name");
		String driverPath=null;
		if(OS.toUpperCase().contains("WINDOWS"))
		{
			log.info("Operating system found : WINDOWS");
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".\\src\\main\\java\\com\\callhub\\flipkart\\resources\\chromedriver.exe";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".\\src\\main\\java\\com\\callhub\\flipkart\\resources\\geckodriver.exe";
				
			}
		}
		else if(OS.toUpperCase().contains("MAC"))
		{
			log.info("Operating System found : MAC");
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".\\src\\main\\java\\com\\callhub\\flipkart\\resources\\chromedriver.exe";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".\\src\\main\\java\\com\\callhub\\flipkart\\resources\\geckodriver.exe";
			}
		}
		return driverPath;
	}

	
}
