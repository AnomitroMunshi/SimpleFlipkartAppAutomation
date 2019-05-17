package com.callhub.flipkart.report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport 
{
	public static ExtentReports report=null;
	public static ExtentTest logger=null;

	//private constructor to limit initialization to one
	private ExtentReport()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		
		report=new ExtentReports(".\\ExtentReports\\Test Report_"+currentDate+".html");
		report.loadConfig(new File(".\\src//main//resources//extentreport.xml"));
	}
	//Initializes Report
	public static void initialize()
	{
		ExtentReport report=new ExtentReport();
	}
}
