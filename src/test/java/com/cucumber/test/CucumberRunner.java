package com.cucumber.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin   = { "pretty", "html:target/site/cucumber-pretty.html", "rerun:target/rerun.txt",
					"json:target/cucumber.json" }, 
		features = {"src/main/resources/Login.feature" }, 
		glue     = { "com.cucumber.test" },
		monochrome = true
	
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
