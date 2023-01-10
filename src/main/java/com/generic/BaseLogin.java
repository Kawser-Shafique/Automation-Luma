package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class BaseLogin {

	public void getLogin() {
		WebDriver driver;
		SeleniumPageFactory pf;
		// open browser
		driver = DriverManager.getBrowser("chrome");
		pf = new SeleniumPageFactory(driver);
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		
		// go to url
		driver.navigate().to(Constants.URL);
		ScreenShot.getScreenShot(driver, "Home Page");
		// Explicit wait
		SeleniumWait.getExplicitWait(driver, pf.getSignInBtn().get(0), 3);
		
		// Click Sign in
		HighLighter.getColor(driver, pf.getSignInBtn().get(0), "red");
		pf.getSignInBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Login Page");
		
		// Put User
		HighLighter.getColor(driver, pf.getEmail(), "blue");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		
		// put password
		HighLighter.getColor(driver, pf.getPassword(), "green");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
		
		// Click Second Sign in Btn
		HighLighter.getColor(driver, pf.getSecondSignInBtn(), "orange");
		pf.getSecondSignInBtn().click();

		// validation
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
