package com.selenium.testcases.selenium_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestng {
	WebDriver w;
	
	
  @BeforeTest
  public void preCondition() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\akanksha singh\\Desktop\\Selenium Practice\\selenium-test\\Driver\\chromedriver.exe");
       w=new ChromeDriver();
    
  }
  
  
  @Test(priority = 0,description = "Test to verify login of mutual fund app",groups="MutualFund" )
  public void loginAdmin() throws Exception {
	   w.get("https://demo.testfire.net/login.jsp");        
       w.findElement(By.id("uid")).sendKeys("admin");
       w.findElement(By.name("passw")).sendKeys("admin");       
       w.findElement(By.name("btnSubmit")).click();    
       
       
       
       TakesScreenshot ts=(TakesScreenshot)w;
		File fin=ts.getScreenshotAs(OutputType.FILE);		
		
		String projectPath=System.getProperty("user.dir");		
		File fout=new File(projectPath+"\\Screenshoot\\Admin.png");
		
		FileUtils.copyFile(fin, fout);
       
       
       w.findElement(By.linkText("Sign Off")).click();
	
  }
  
  @Test(priority = 1,description = "Test to verify login of mutual fund app",dependsOnMethods = "loginAdmin",groups="MutualFund" , enabled = true,invocationCount   =3  )
  public void loginTestUser() throws Exception {
	   w.get("https://demo.testfire.net/login.jsp");        
       w.findElement(By.id("uid")).sendKeys("tuser");
       w.findElement(By.name("passw")).sendKeys("tuser");       
       w.findElement(By.name("btnSubmit")).click();   
       
       TakesScreenshot ts=(TakesScreenshot)w;
		File fin=ts.getScreenshotAs(OutputType.FILE);		
		
		String projectPath=System.getProperty("user.dir");		
		File fout=new File(projectPath+"\\Screenshoot\\Tuser.png");
		
		FileUtils.copyFile(fin, fout);
       
       w.findElement(By.xpath("/html/body/div[1]/form/table/tbody/tr[1]/td[2]/a[1]")).click();
	
  }
  
  
  
  @Test(priority = 2,description = "Test to verify login of Kroger ap",groups="Kroger" )
  public void userLogin() throws IOException   
  {
	  System.out.println("Login into Kroger");
	  
	  w.get("https://www.kroger.com/signin"); 
	  w.findElement(By.id("SignIn-emailInput")).sendKeys("Asingh141992@gmail.com");
	  w.findElement(By.name("password")).sendKeys("Summer@18");       
      w.findElement(By.id("SignIn-submitButton")).click(); 
      
      TakesScreenshot ts=(TakesScreenshot)w;
		File fin=ts.getScreenshotAs(OutputType.FILE);		
		
		String projectPath=System.getProperty("user.dir");		
		File fout=new File(projectPath+"\\Screenshoot\\kroger.png");
		
		FileUtils.copyFile(fin, fout);
	  
  }

 

  @AfterTest
  public void postCondition() {
	  w.quit();
  }

}
