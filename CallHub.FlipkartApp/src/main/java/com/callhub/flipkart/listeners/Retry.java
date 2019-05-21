package com.callhub.flipkart.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;



public class Retry implements IRetryAnalyzer {
	public static Logger log=LogManager.getLogger(Retry.class.getName());

	int counter = 0;
	 int retryLimit = 2;
	 
	public boolean retry(ITestResult result) {
		
		if(counter < retryLimit){
			counter++;
			log.info("Retry no: "+counter);
			
			return true;
		 }
		log.info("2 times retry done!");
		 return false;
	 }
}


