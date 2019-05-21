package com.callhub.flipkart.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.callhub.flipkart.base.Driver;


public class Listener  implements ITestListener {
	public static Logger log=LogManager.getLogger(Listener.class.getName());
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Started! ");
		log.info(result.getMethod().getMethodName()+" Started! ");
		System.out.println("=============================================================================");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" test Success! ");
		log.info(result.getMethod().getMethodName()+" test successfull! ");
		System.out.println("=============================================================================");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" test failed! ");
		log.info(result.getMethod().getMethodName()+" test failed! ");
		System.out.println("=============================================================================");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" test Skipped! ");
		log.info(result.getMethod().getMethodName()+"test skipped! ");
		log.info("Retrying...........");
		System.out.println("=============================================================================");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
				
	}

	public void onFinish(ITestContext context) {
		
		
	}

}
