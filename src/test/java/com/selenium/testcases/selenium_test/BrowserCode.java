package com.selenium.testcases.selenium_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserCode {
  
	WebDriver w;
	//path -> workspace dir -> project diretory
	String projectPath=System.getProperty("user.dir");
	
  @Test(priority = 0,description = "verify Chrome")
  public void chrome() {
	  System.setProperty("webdriver.chrome.driver",projectPath+"\\Driver\\chromedriver.exe");
        w=new ChromeDriver();
        w.get("https://www.google.com/");
        String title=w.getTitle();
        Assert.assertEquals(title,"Google");
	  
  }
  
  
  @Test(priority = 1,description = "verify firefox")
  public void firefox() {
	  System.setProperty("webdriver.gecko.driver",projectPath+"\\Driver\\geckodriver.exe");
      w=new FirefoxDriver();
      w.get("https://www.google.com/");
      String title=w.getTitle();
      Assert.assertEquals(title,"Google");
	  
  }

  
  @Test(priority = 2,description = "verify Edge")
  public void Edge() {
	  System.setProperty("webdriver.edge.driver",projectPath+"\\Driver\\msedgedriver.exe");
      w=new EdgeDriver();
      w.get("https://www.google.com/");
      String title=w.getTitle();
      Assert.assertEquals(title,"Google");
	  
  }


}
