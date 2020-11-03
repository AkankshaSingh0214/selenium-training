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

public class LoginTC {

	WebDriver w;

	@Given("Browser should be with login page for testing admin user")
	public void browser_should_be_with_login_page_for_testing_admin_user() {

		WebDriverManager.chromiumdriver().setup();
		w = new ChromeDriver();
		w.get("https://demo.testfire.net/login.jsp");

	}

	@When("User should logs in using Username and Password as admin")
	public void user_should_logs_in_using_username_and_password_as_admin() {

		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");

	}

	@And("Click on Login button for testing admin user")
	public void click_on_login_button_for_testing_admin_user()throws Exception {
		w.findElement(By.name("btnSubmit")).click();
                 Thread.sleep(3000);
	}

	@Then("Home Page should get open and verify page title for admin")
	public void home_page_should_get_open_and_verify_page_title_for_admin() {

		String pageTitle = w.getTitle();
		Assert.assertEquals("Altoro Mutual", pageTitle);
	}

	@And("Close browser")
	public void close_browser() {

		w.quit();
	}

}
