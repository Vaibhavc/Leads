package com.practice.qa;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/**
 * Please notice that cucumber.examples.java.testNG.stepDefinitions.BeforeAfterHooks class
 * is in the same package as the steps definitions.
 * It has two methods that are executed before or after scenario.
 * I'm using it to delete cookies and take a screenshot if scenario fails.
 */
@CucumberOptions(
        features = "./src/test/resources/feature",
        glue = {"com.practice.qa"},
        dryRun=false,
        plugin = {"pretty",
                "json:target/cucumber-report/chrome/cucumber.json"},strict = true,tags="@Email")
public class Runner extends AbstractTestNGCucumberTests {
	
}
