package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestng_Alert {
	WebDriver w;
	
	
  @BeforeTest
  public void preCondition() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\akanksha singh\\Desktop\\Selenium Practice\\selenium-test\\Driver\\chromedriver.exe");
       w=new ChromeDriver();
    
  }
  
  
  @Test(priority = 0,description = "Test to verify login of mutual fund app",groups="MutualFund" )
  public void loginAdmin() {
	   w.get("https://demo.testfire.net/login.jsp");   
	   
	   w.findElement(By.id("uid")).clear();
       w.findElement(By.id("uid")).sendKeys("1");
       w.findElement(By.name("btnSubmit")).click();        
      
	   
       w.switchTo().alert().accept();
	   
	   w.findElement(By.id("uid")).clear();
       w.findElement(By.id("uid")).sendKeys("admin");
       w.findElement(By.id("passw")).clear();
       w.findElement(By.name("passw")).sendKeys("admin");       
       w.findElement(By.name("btnSubmit")).click();        
       w.findElement(By.linkText("Sign Off")).click();
	
  }
  
  
 

  @AfterTest
  public void postCondition() {
	//  w.quit();
  }

}
