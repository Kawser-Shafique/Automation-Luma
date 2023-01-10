package com.generic;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class FinalLoginPractice {

	public static void getFinalLogin() {

		// open browser
		WebDriver driver = DriverManager.getBrowser("chrome");
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		// go to application URL
		driver.navigate().to(Constants.URL);
		// Home Page Screen Shot
		ScreenShot.getScreenShot(driver, "Home Page");
		SeleniumWait.getExplicitWait(driver, pf.getSignInBtn().get(0), 3);
		// click sign in button
		HighLighter.getColor(driver, pf.getSignInBtn().get(0), "blue");
		pf.getSignInBtn().get(0).click();
		// Login Page Screen Shot
		ScreenShot.getScreenShot(driver, "Login Page");
		// put email
		HighLighter.getColor(driver, pf.getEmail(), "orange");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		// put password
		HighLighter.getColor(driver, pf.getPassword(), "green");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
		// click second sign in button
		HighLighter.getColor(driver, pf.getSecondSignInBtn(), "purple");
		pf.getSecondSignInBtn().click();
		// validation = Welcome Sarower Ahmmed
		// java if else
//		if (pf.getWelcome().get(0).isDisplayed()) {
//			System.out.println("Test Passed");
//		} else {
//			System.out.println("Test Failed");
//		}
//		// Hard Assert
//		Assert.assertTrue(pf.getWelcome().get(0).isDisplayed());
		
		// Login Validation Screen Shot
		ScreenShot.getScreenShot(driver, "Login Validation");
		// soft assert
		HighLighter.getColor(driver, pf.getWelcome().get(0), "red");
		boolean status = pf.getWelcome().get(0).isDisplayed();

		SoftAssert sf = new SoftAssert();
		sf.assertTrue(status);
		System.out.println(status);
		sf.assertAll();
		
		
		driver.quit();
	}

	public static void main(String[] args) {
		getFinalLogin();
	}
}
