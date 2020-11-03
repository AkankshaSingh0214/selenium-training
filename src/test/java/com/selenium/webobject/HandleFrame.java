package com.selenium.webobject;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleFrame {
	WebDriver w;

	@BeforeTest
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akanksha singh\\Desktop\\Selenium Practice\\selenium-test\\Driver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();
		

	}

	@Test(priority = 0, description = "Test to verify login of mutual fund app", groups = "MutualFund")
	public void loginAdmin() throws Exception {
		w.get("https://s1.demo.opensourcecms.com/s/5");

		w.switchTo().frame("preview-frame");
		
		w.findElement(By.id("q")).clear();
		w.findElement(By.id("q")).sendKeys("Testing");

		//Dimension d=new Dimension(900, 700);
		//w.manage().window().setSize(d);
		
		TakesScreenshot ts=(TakesScreenshot)w;
		File fin=ts.getScreenshotAs(OutputType.FILE);		
		
		String projectPath=System.getProperty("user.dir");		
		File fout=new File(projectPath+"\\Screenshoot\\Sample.png");
		
		FileUtils.copyFile(fin, fout);
	}

}
