package com.selenium.logintc;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.pageobject.LoginPageObj;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.pageobject.ListenerCode.class)

public class LoginTestCases1 {

	LoginPageObj lp = new LoginPageObj();
	
	ExtentHtmlReporter htmlreporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	                 

	@BeforeTest
	public void beforeTest() {
		
		lp.openBrowser("edge");
		lp.exportPageFactory();	
		String projectPath=System.getProperty("user.dir");
		htmlreporter=new ExtentHtmlReporter(projectPath+"\\TestReport\\RegressionReport.html");
		htmlreporter.config().setDocumentTitle("Regression Title");
		htmlreporter.config().setReportName("Regresssion Report Name ");
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(htmlreporter);
		
		extentReports.setSystemInfo("UserName", "Selenium User");
		extentReports.setSystemInfo("OS", "win10");
		extentReports.setSystemInfo("programming", "Java");
		extentReports.setSystemInfo("Automation  tool", "Selenium 3.141.59");


		
		
		
	}

	@Test(priority = 0,description = "verify admin user")
	public void adminUser() throws Exception { 
		
		extentTest=extentReports.createTest("Login Admin");
		
		
		lp.openApplication();

		lp.txtUsername.sendKeys("admin");
		lp.txtPassword.sendKeys("admin");
		lp.btnSubmit.click();
		lp.delay(3);
		
		Assert.assertEquals(lp.verifyTitle(), "Altoro Mutual");
		Assert.assertTrue(lp.verifyElementText(lp.userProfile).contains("Admin"),"Admin labele not found");
		
		lp.linkSignOff.click();
		
	}
	
	@Test(priority = 1,description = "verify tuser user")
	public void tuserUser() throws Exception { 
		
		extentTest=extentReports.createTest("Login Tuser");

		
		lp.openApplication();

		lp.txtUsername.sendKeys("tuser");
		lp.txtPassword.sendKeys("tuser");
		lp.btnSubmit.click();
		lp.delay(3);
		
		Assert.assertEquals(lp.verifyTitle(), "Altoro Mutua");
		
		lp.linkSignOff.click();
		
	}
	

	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {			
			extentTest.log(Status.FAIL, result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS) {			
			extentTest.log(Status.PASS, result.getName());
		}
		
		extentReports.flush();
	}
	

	@AfterTest
	public void afterTest() {
		lp.closeBrowser();
	}

}
