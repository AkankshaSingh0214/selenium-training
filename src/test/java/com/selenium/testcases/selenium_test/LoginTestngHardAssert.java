package com.selenium.testcases.selenium_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestngHardAssert {
	WebDriver w;
	
	
  @BeforeTest
  public void preCondition() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\akanksha singh\\Desktop\\Selenium Practice\\selenium-test\\Driver\\chromedriver.exe");
       w=new ChromeDriver();
    
  }
  
  
  @Test(priority = 0,description = "Test to verify login of mutual fund app",groups="MutualFund" )
  public void loginAdmin() {
	   w.get("https://demo.testfire.net/login.jsp");
	   
	   String currentPageTitle=w.getTitle();	   
	   Assert.assertEquals(currentPageTitle, "Altoro Mutual");
	   
	   WebElement currentPageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
        String label=currentPageLabel.getText();        
	   Assert.assertTrue(label.contains("Login"),"Label is different");
	   
       w.findElement(By.id("uid")).sendKeys("admin");
       w.findElement(By.name("passw")).sendKeys("admin");       
       w.findElement(By.name("btnSubmit")).click();        
	
  }
  
  
  @Test(priority = 1,description = "Test to verify logout of mutual fund app",groups="MutualFund" )
  public void logoutAdmin() {
     
	  String currentPageTitle=w.getTitle();	   
	   Assert.assertEquals(currentPageTitle, "Altoro Mutual");
	   
	   WebElement currentPageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
       String label=currentPageLabel.getText();        
	   Assert.assertTrue(label.contains("Admin"),"Label is different");
	   
	   WebElement gobtn=w.findElement(By.id("btnGetAccount"));
	   Assert.assertTrue(gobtn.isDisplayed(),"Go button not avaiable");
	 
	  w.findElement(By.linkText("Sign Off")).click();

  }

  @AfterTest
  public void postCondition() {
	//  w.quit();
  }

}
