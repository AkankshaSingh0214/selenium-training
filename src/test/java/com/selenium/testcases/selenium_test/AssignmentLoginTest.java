package com.selenium.testcases.selenium_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AssignmentLoginTest {
	
	WebDriver w;
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\akanksha singh\\Desktop\\Selenium Practice\\selenium-test\\Driver\\chromedriver.exe");
      w=new ChromeDriver();
   
  }
  
  @Test
  public void userLogin() 
  
  {
	  System.out.println("Login into Kroger");
	  
	  w.get("https://www.kroger.com/signin"); 
	  w.findElement(By.id("SignIn-emailInput")).sendKeys("Asingh141992@gmail.com");
	  w.findElement(By.name("password")).sendKeys("Summer@18");       
      w.findElement(By.id("SignIn-submitButton")).click();        
      w.findElement(By.id("WelcomeMenu-signOut")).click();
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
