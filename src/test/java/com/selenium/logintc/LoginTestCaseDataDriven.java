package com.selenium.logintc;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.pageobject.LoginPageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.pageobject.ListenerCode.class)

public class LoginTestCaseDataDriven {

	LoginPageObj lp = new LoginPageObj();
	FileInputStream fin;
	XSSFWorkbook wb;
	XSSFSheet sheet;

	@BeforeTest
	public void beforeTest() throws Exception {

		lp.openBrowser(lp.readPropertiesFileData("browser"));
		lp.exportPageFactory();

		String projectPath = System.getProperty("user.dir");

		fin = new FileInputStream(projectPath + "\\testdata\\LoginDataMutual.xlsx");
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet("Sheet1");

	}

	@Test(priority = 0, description = "verify admin user")
	public void adminUser() throws Exception {

		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++)  {
			
			// i -> rows
			int j=0; // j -> cells
			
			XSSFRow row = sheet.getRow(i);
			
			XSSFCell usernamecell = row.getCell(j);
			String usernameValue=usernamecell.toString();
			
			XSSFCell passwordcell = row.getCell(j+1);
			String passwordValue=passwordcell.toString();



			lp.openApp(lp.readPropertiesFileData("baseUrl"));

			lp.txtUsername.sendKeys(usernameValue);
			lp.txtPassword.sendKeys(passwordValue);

			lp.btnSubmit.click();
			lp.delay(3);

			lp.linkSignOff.click();

		}
	}

	@AfterTest
	public void afterTest() {
		lp.closeBrowser();
	}

}
