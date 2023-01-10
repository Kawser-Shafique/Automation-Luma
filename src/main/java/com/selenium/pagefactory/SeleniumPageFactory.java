package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	WebDriver driver;
	public SeleniumPageFactory (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@class='authorization-link']")
	private List<WebElement> signInBtn;
	
	@FindBy(xpath="//*[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//*[@title='Password']")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='action login primary']")
	private WebElement secondSignInBtn;
	
	@FindBy(xpath="//*[@class='greet welcome']")
	private List<WebElement> welcome;
	
	//*[@class='authorization-link']
	@FindBy(xpath="//*[@class='authorization-link']")
	private List<WebElement> logOutBtn;
	
	//costco webpage
	
	//*[text()='Sign In / Register']
	@FindBy(xpath="//*[text()='Sign In / Register']")
	private List<WebElement> costcoSignIn;
	
	//*[@id='navigation-widget']//a
	@FindBy(xpath="//*[@id='navigation-widget']//a")
	private List<WebElement> costcoMenuBtn;
	
	//*[@class='sub-item']
	@FindBy(xpath="//*[@class='sub-item']")
	private List<WebElement> dealOptions;
	
	//*[text()='Computers']
	@FindBy(xpath="//*[text()='Computers']")
	private WebElement computersBtn;
	
	//*[contains(text(),'Show more options  ')]
	@FindBy(xpath="//*[contains(text(),'Show more options  ')]")
	private List<WebElement> seeMoreOptionsBtn;
	
	//*[@id='accordion-filter_collapse-1']//label
	@FindBy(xpath="//*[@id='accordion-filter_collapse-1']//label")
	private List<WebElement> catagoryMenuBtn;
	
	//*[@id='accordion-filter_collapse-1']//a
	//*[text()=' Laptops & Notebook Computers']
	@FindBy(xpath="//*[text()=' Laptops & Notebook Computers']")
	private List<WebElement> laptopsAndNotebookBtn;
	
	//*[text()=' PC Laptops']
	@FindBy(xpath="//*[text()=' PC Laptops']")
	private List<WebElement> pcLaptops;
	
	//*[@id='sort_by']
	@FindBy(xpath="//*[@id='sort_by']")
	private WebElement dropDown;
	
	//*[@class='thumbnail']
	//*[@class='price']
	@FindBy(xpath="//*[@class='price']")
	private List<WebElement> productPrices;
	
	public List<WebElement> getSignInBtn() {
		return signInBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSecondSignInBtn() {
		return secondSignInBtn;
	}

	public List<WebElement> getWelcome() {
		return welcome;
	}
	
	
	public List<WebElement> getLogOutBtn() {
		return logOutBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}
	// Coscto Web page
	public List<WebElement> getCostcoSignIn() {
		return costcoSignIn;
	}

	
	public List<WebElement> getCostcoMenuBtn() {
		return costcoMenuBtn;
	}

	public List<WebElement> getDealOptions() {
		return dealOptions;
	}

	public WebElement getComputersBtn() {
		return computersBtn;
	}

	
	public List<WebElement> getSeeMoreOptionsBtn() {
		return seeMoreOptionsBtn;
	}

	public List<WebElement> getCatagoryMenuBtn() {
		return catagoryMenuBtn;
	}

	public List<WebElement> getLaptopsAndNotebookBtn() {
		return laptopsAndNotebookBtn;
	}

	public List<WebElement> getPcLaptops() {
		return pcLaptops;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public List<WebElement> getProductPrices() {
		return productPrices;
	}

	
	
	
	

}
