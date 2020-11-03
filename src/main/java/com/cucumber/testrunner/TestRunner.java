package com.cucumber.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"Features"},
		glue= {"com.cucumber.stepdefinition"},
		plugin= {"pretty","html:target/Cucumberreport.html"},
		monochrome=true,
		tags="@Smoke or @Sanity"
		)



public class TestRunner {

}
