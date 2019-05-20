package com.callhub.flipkart.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.callhub.flipkart.base.Driver;

public class Listener  implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Started! ");
		System.out.println("=============================================================================");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Success! ");
		System.out.println("=============================================================================");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Failed! ");
		System.out.println("=============================================================================");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Skipped! ");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
				
	}

	public void onFinish(ITestContext context) {
		
		
	}

}
