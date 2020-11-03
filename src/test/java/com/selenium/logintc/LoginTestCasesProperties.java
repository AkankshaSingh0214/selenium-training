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

public class LoginTestCasesProperties {

	LoginPageObj lp = new LoginPageObj();
	
	                 

	@BeforeTest
	public void beforeTest() throws Exception {
		
		lp.openBrowser(lp.readPropertiesFileData("browser"));
		lp.exportPageFactory();	
	
	}

	@Test(priority = 0,description = "verify admin user")
	public void adminUser() throws Exception { 
		
		
		lp.openApp(lp.readPropertiesFileData("baseUrl"));

		lp.txtUsername.sendKeys(lp.readPropertiesFileData("username"));
		lp.txtPassword.sendKeys(lp.readPropertiesFileData("password"));
		lp.btnSubmit.click();
		lp.delay(3);
		
		Assert.assertEquals(lp.verifyTitle(), "Altoro Mutual");
		Assert.assertTrue(lp.verifyElementText(lp.userProfile).contains("Admin"),"Admin labele not found");
		
		lp.linkSignOff.click();
		
	}
	
	

	@AfterTest
	public void afterTest() {
		lp.closeBrowser();
	}

}
