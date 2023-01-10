package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;

	@Given("Open a browser")
	public void open_a_browser() {
		driver = DriverManager.getBrowser("chrome");
		pf = new SeleniumPageFactory(driver);
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
	}

	@Given("go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver, "Home Page");
		// Explicit wait
		SeleniumWait.getExplicitWait(driver, pf.getSignInBtn().get(0), 3);
	}

	@When("Click sign in button")
	public void click_sign_in_button() {
		HighLighter.getColor(driver, pf.getSignInBtn().get(0), "red");
		pf.getSignInBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Login Page");
	}

	@When("put email")
	public void put_email() {
		HighLighter.getColor(driver, pf.getEmail(), "blue");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
	}

	@When("put password")
	public void put_password() {
		HighLighter.getColor(driver, pf.getPassword(), "green");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
	}

	@When("click second sign in button")
	public void click_second_sign_in_button() {
		HighLighter.getColor(driver, pf.getSecondSignInBtn(), "orange");
		pf.getSecondSignInBtn().click();
	}

	@Then("validate login was successful")
	public void validate_login_was_successful() {
		HighLighter.getColor(driver, pf.getWelcome().get(0), "pink");
		boolean status = pf.getWelcome().get(0).isDisplayed();
		// Assertion = hard & soft
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(status);
		ScreenShot.getScreenShot(driver, "Login Validation");

		// close browser
		// driver.quit();
	}

}
