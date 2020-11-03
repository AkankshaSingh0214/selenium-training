package com.selenium.testcases.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTC {

	public static void main(String[] args) {

        System.out.println("Start Selenium");
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akanksha singh\\Desktop\\Selenium Practice\\selenium-test\\Driver\\chromedriver.exe");
        WebDriver w=new ChromeDriver();
        
       w.get("https://demo.testfire.net/login.jsp");        
       w.findElement(By.id("uid")).sendKeys("admin");
       w.findElement(By.name("passw")).sendKeys("admin");       
       w.findElement(By.name("btnSubmit")).click();        
       w.findElement(By.xpath("/html/body/div[1]/form/table/tbody/tr[1]/td[2]/a[1]")).click();
		
       
       w.quit();
       System.out.println("Done Execution..");
	}

}
