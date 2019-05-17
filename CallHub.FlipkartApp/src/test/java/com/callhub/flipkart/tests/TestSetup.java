package com.callhub.flipkart.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.report.ExtentReport;



public class TestSetup {
	 //Initializes browser and reports
	  @BeforeSuite
	  public void beforeSuite() 
	  {
		 // ExtentReport.initialize();
		  
		  //ExtentReport.logger= ExtentReport.report.startTest("FlipKart Application Test");
		  Driver.initialize();
		  

	  }
	//closed browser and report object
	  @AfterSuite
	  public void afterSuite() 
	  {
		  Driver.quit();
		//  ExtentReport.report.flush();
		  
	  }

	}

