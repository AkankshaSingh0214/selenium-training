package com.selenium.testcases.selenium_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCodeWebDriverMnaager {
  
	WebDriver w;
	
  @Test(priority = 0,description = "verify Chrome")
  public void chrome() {
	  
	  WebDriverManager.chromedriver().setup();
	  
	  w=new ChromeDriver();
        w.get("https://www.google.com/");
        String title=w.getTitle();
        Assert.assertEquals(title,"Google");
	  
  }
  
  
  @Test(priority = 1,description = "verify firefox")
  public void firefox() {
	
	  WebDriverManager.firefoxdriver().setup();
	  w=new FirefoxDriver();
      w.get("https://www.google.com/");
      String title=w.getTitle();
      Assert.assertEquals(title,"Google");
	  
  }

  
  @Test(priority = 2,description = "verify Edge")
  public void Edge() {
	  
	  WebDriverManager.edgedriver().setup();
	  
	  w=new EdgeDriver();
      w.get("https://www.google.com/");
      String title=w.getTitle();
      Assert.assertEquals(title,"Google");
	  
  }


}
