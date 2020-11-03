package com.cucumber.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTuser {
	WebDriver w;
	
	@Given("Browser should be with login page for testing tuser user")
	public void browser_should_be_with_login_page_for_testing_tuser_user() {
	
		WebDriverManager.chromiumdriver().setup();
		w = new ChromeDriver();
		w.get("https://demo.testfire.net/login.jsp");

	}

	@When("User should logs in using Username as {string} and Password {string}")
	public void user_should_logs_in_using_username_as_and_password(String string, String string2) {
	
	
		w.findElement(By.id("uid")).sendKeys(string);
		w.findElement(By.id("passw")).sendKeys(string2);
	}

	@And("Click on Login button for testing tuser user")
	public void click_on_login_button_for_testing_tuser_user() {
		w.findElement(By.name("btnSubmit")).click();
	}

	@Then("Home Page should get open and verify page title for tuser")
	public void home_page_should_get_open_and_verify_page_title_for_tuser() {
		String pageTitle = w.getTitle();
		Assert.assertEquals("Altoro M", pageTitle);
	
	}

	@And("Close browser after login")
	public void close_browser_after_login() {
		w.quit();
	}

}
