package com.selenium.webobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountWebObject {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "count radio button")
	public void radiobutton() {

		w.get("http://demo.automationtesting.in/Register.html");
		
		
	List<WebElement> radio=w.findElements(By.name("radiooptions"));
		
		System.out.println("Radio button : "+radio.size());
		
		
	}
	
	
	@Test(priority = 1, description = "count checkbox")
	public void checkbox() {		
		
		List<WebElement> checkbox=w.findElements(By.cssSelector("input[type='checkbox']"));
		
		System.out.println("Checkbox button : "+checkbox.size());
		
		
	}
	
	@Test(priority = 2, description = "count drop down values")
	public void dropdown() {		
		
		WebElement Skills=w.findElement(By.id("Skills"));
		
		Select sel=new Select(Skills);
		
		List<WebElement> skills_data=sel.getOptions();

		
	}

}
