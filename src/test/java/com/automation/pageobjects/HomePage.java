package com.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.testcases.DriverSetup;

//Page class for home page to maintain the required web elements present on home page along with corresponding methods
public class HomePage extends DriverSetup {
	
	public HomePage(WebDriver driver) { //Constructor to initiate driver object for the page class
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='login']")
	@CacheLookup
	WebElement signinButton;

	public void clickSigninButton() {
		signinButton.click();
	}
	
	@FindBy(xpath = "//div[@class='header_user_info']/a/span[1]")
	@CacheLookup
	WebElement loggedUserName;

	public void verifyLogin() {
		Assert.assertEquals(loggedUserName.getText(), username, "Login failed!");
	}
	
	public void clickUserAccount() {
		loggedUserName.click();
	}
	
	@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a")
	@CacheLookup
	WebElement dressesSection;

	public void clickDressesSection() {
		dressesSection.click();
	}
	
	
	
	

}
