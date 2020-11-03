package com.selenium.pageobject;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerCode implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {

        System.out.println("Test Cases passed : "+result.getMethod().getDescription());		
		Reporter.log("Test Cases passed : "+result.getMethod().getDescription());		

	}

	public void onTestFailure(ITestResult result) {

        System.out.println("Test Cases failed : "+result.getMethod().getDescription());		
		Reporter.log("Test Cases failed : "+result.getMethod().getDescription());		

	}

	public void onTestSkipped(ITestResult result) {

        System.out.println("Test Cases skipped : "+result.getMethod().getDescription());		
		Reporter.log("Test Cases skipped : "+result.getMethod().getDescription());		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
