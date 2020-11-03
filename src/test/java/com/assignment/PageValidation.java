package com.assignment;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PageValidation {
	
	WebDriver w;
  
  @BeforeTest
	  
  public void invokeSite()
  {
	  WebDriverManager.chromedriver().setup();
	  
	  w=new ChromeDriver();
	  w.get("https://www.policyx.com/");
	  
	  String title=w.getTitle();
	  Assert.assertEquals(title, "India's Most Trusted Insurance Portal");
	  }
	
  @Test
  public void f() {
  }
  
  @AfterTest
  public void afterTest() {
  }

}
