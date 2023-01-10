package com.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class CostcoAutomation {
	// WebDriver driver;
	// SeleniumPageFactory pf;
	public static void productHandle() {
		// Go to https://www.costco.com/
		WebDriver driver = DriverManager.getBrowser("chrome");
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		driver.manage().window().maximize();
		driver.navigate().to(Constants.COSTCO_URL);
		SeleniumWait.getImplicitWait(driver, 5);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));//= GUI=>
		// wait until GUI loaded
		// get the page name => title=> getTitle()
		// driver.getTitle();
		System.out.println("Home page title/name = " + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco Home Welcome Page");
		// check validate current URL is matched or not => getCurrentURL();
		// driver.getCurrentUrl();
		System.out.println("Current page URL = " + driver.getCurrentUrl());
		// Exceptions = Constants.COSTCO_URL, actual = driver.getCurrentUrl()
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(driver.getCurrentUrl(), Constants.COSTCO_URL);
		// go to sign in page
		// *[text()='Sign In / Register']
		SeleniumWait.getExplicitWait(driver, pf.getCostcoSignIn().get(0), 30);
		HighLighter.getColor(driver, pf.getCostcoSignIn().get(0), "red");
		pf.getCostcoSignIn().get(0).click();
		// get the page name
		System.out.println("Login page title/name = " + driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco Sign In Page");
		// go back to the home page >> navigate().back();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
		driver.navigate().back();
		while (true) {// true==> infinite loop
			if (pf.getCostcoSignIn().size() > 0) {
				break;
			} else {
				driver.navigate().back();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// Read all options and count options below the login button
		// pf.getCosctoMenuBtn() = list = all ==> loop = forloop
		System.out.println("Menu count = " + pf.getCostcoMenuBtn().size());
		for (int i = 0; i < pf.getCostcoMenuBtn().size(); i++) {
			HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "white");
			System.out.println(pf.getCostcoMenuBtn().get(i).getText());
		}
		// If the deal was there, then mouse over it and read all options
		// mouse hover => Actions class => moveToElement()

		for (int i = 0; i < pf.getCostcoMenuBtn().size(); i++) {// 1st loop
			if (pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {// true
				HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "red");
				Actions ac = new Actions(driver);
				ac.moveToElement(pf.getCostcoMenuBtn().get(i)).perform();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Deal options count = " + pf.getDealOptions().size());
				// Read name of All deal options==> loop
				for (int j = 0; j < pf.getDealOptions().size(); j++) {// 2nd loop
					HighLighter.getColor(driver, pf.getDealOptions().get(j), "green");
					System.out.println(pf.getDealOptions().get(j).getText());
				}
				break;
			}

		}
		// If the computer section was there inside the deal, then click it
		SeleniumWait.getExplicitWait(driver, pf.getComputersBtn(), 30);
		HighLighter.getColor(driver, pf.getComputersBtn(), "purple");
		pf.getComputersBtn().click();

		// Read all categories and select Laptops
		pf.getSeeMoreOptionsBtn().get(0).click();
		System.out.println("Catagory Options Count = " + pf.getCatagoryMenuBtn().size());
		for (int k = 0; k < pf.getCatagoryMenuBtn().size(); k++) {
			HighLighter.getColor(driver, pf.getCatagoryMenuBtn().get(k), "blue");
			System.out.println(pf.getCatagoryMenuBtn().get(k).getText());
		}
		for (int l = 0; l < pf.getCatagoryMenuBtn().size(); l++) {
			if (pf.getCatagoryMenuBtn().get(l).getText().contains("Laptops & Notebook Computers")) {// true
				Actions ac = new Actions(driver);
				ac.moveToElement(pf.getCatagoryMenuBtn().get(l)).perform();
			}
			// can be click without mousehover
			// pf.getLaptopsAndNotebookBtn().get(0).click();
		}
		SeleniumWait.getExplicitWait(driver, pf.getLaptopsAndNotebookBtn().get(0), 30);
		HighLighter.getColor(driver, pf.getLaptopsAndNotebookBtn().get(0), "red");
		pf.getLaptopsAndNotebookBtn().get(0).click();

		// Find out how many laptops there
		for (int m = 0; m < pf.getPcLaptops().size(); m++) {
			HighLighter.getColor(driver, pf.getPcLaptops().get(m), "green");
			System.out.println(pf.getPcLaptops().get(m).getText());
		}
		pf.getPcLaptops().get(0).click();

		// Sort the laptop price from high to low
		Select select = new Select(pf.getDropDown());
		select.selectByVisibleText("Price (High to Low)");

		// Find out the highest laptop price and name on 1st page

		List<WebElement> productPrices = pf.getProductPrices();
		List<String> allProductPricesName = new ArrayList<>();
		for (int n = 0; n < productPrices.size(); n++) {
			allProductPricesName.add(productPrices.get(n).getText());
			System.out.println(productPrices.get(n).getText().replace("$", ""));

		}
		System.out.println(Collections.max(allProductPricesName));

		sf.assertAll();
	}

	public static void main(String[] args) {
		productHandle();
	}
}
