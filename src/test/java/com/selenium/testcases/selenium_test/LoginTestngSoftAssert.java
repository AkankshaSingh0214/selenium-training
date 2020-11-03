package com.selenium.testcases.selenium_test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestngSoftAssert {
	WebDriver w;
	
	SoftAssert st;
	
  @BeforeTest
  public void preCondition() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\akanksha singh\\Desktop\\Selenium Practice\\selenium-test\\Driver\\chromedriver.exe");
       w=new ChromeDriver();
     //  st=new SoftAssert();
  }
  
  
  @Test(priority = 0,description = "Test to verify login of mutual fund app",groups="MutualFund" )
  public void loginAdmin() {
	  st=new SoftAssert();
	  
	  w.get("https://demo.testfire.net/login.jsp");
	   
	   String currentPageTitle=w.getTitle();	   
	   st.assertEquals(currentPageTitle, "Altoro Login");
	   
	   WebElement currentPageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
        String label=currentPageLabel.getText();        
	   st.assertTrue(label.contains("Login"),"Label is different");
	   
       w.findElement(By.id("uid")).sendKeys("admin");
       w.findElement(By.name("passw")).sendKeys("admin");       
       w.findElement(By.name("btnSubmit")).click();        
	
       st.assertAll();


  }
  
  
  @Test(priority = 1,description = "Test to verify logout of mutual fund app",groups="MutualFund" )
  public void logoutAdmin() {
     st=new SoftAssert();
     
	  String currentPageTitle=w.getTitle();	   
	   st.assertEquals(currentPageTitle, "Altoro Home Page");
	   
	   WebElement currentPageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
       String label=currentPageLabel.getText();        
	   st.assertTrue(label.contains("Admin"),"Label is different");
	   
	   WebElement gobtn=w.findElement(By.id("btnGetAccount"));
	   st.assertTrue(gobtn.isDisplayed(),"Go button not avaiable");
	 
	  w.findElement(By.linkText("Sign Off")).click();

	  st.assertAll();


  }

  @AfterTest
  public void postCondition() {
	//  w.quit();
  }

}
