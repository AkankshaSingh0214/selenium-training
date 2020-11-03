package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class HandleWebObject {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "verify textbox")
	public void textbox() {

		w.get("http://demo.automationtesting.in/Register.html");

		w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Selenium");

		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Testing");

		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("Addresss Sample");

	}

	@Test(priority = 1, description = "verify radiobutton")
	public void radiobutton() {

		w.findElement(By.cssSelector("input[value='Male']")).click();
	}
	
	@Test(priority = 2, description = "verify checkbox")
	public void checkbox() {

		w.findElement(By.cssSelector("input[value='Cricket']")).click();
		w.findElement(By.cssSelector("input[value='Hockey']")).click();

	}
	
	@Test(priority = 3, description = "verify dropDown list")
	public void dropDown() {
		
		WebElement Skills=w.findElement(By.id("Skills"));
		
		Select sel=new Select(Skills);
		
		//sel.selectByIndex(9);
		
		//sel.selectByValue("APIs");
		
		sel.selectByVisibleText("Java");
		
		
		
		
		
	}


	@AfterTest
	public void afterTest() {
	}

}
