package com.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.testcases.DriverSetup;

//Page class for login page to maintain the required web elements present on login page along with corresponding methods
public class LoginPage extends DriverSetup {
	
	public LoginPage(WebDriver driver) { //Constructor to initiate driver object for the page class
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	@CacheLookup
	WebElement userId;

	public void enterUserId() {
		userId.sendKeys(useremail);
	}
	
	@FindBy(id = "passwd")
	@CacheLookup
	WebElement userPwd;

	public void enterUserPwd() {
		userPwd.sendKeys(userpassword);
	}
	
	@FindBy(id = "SubmitLogin")
	@CacheLookup
	WebElement loginButton;

	public void clickLoginButton() {
		loginButton.click();
	}
}
