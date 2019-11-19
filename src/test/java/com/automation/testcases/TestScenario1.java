package com.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LoginPage;
import com.automation.pageobjects.ProductPage;

public class TestScenario1 extends DriverSetup { //Java concept inheritance is used

	protected HomePage hp; //Creating objects for page classed
	protected LoginPage lp;
	protected ProductPage pp;

	public static Logger logs; //Using Log4J to better see failures and step by step info

	@BeforeClass
	public void initializeTesting() {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		logs = Logger.getLogger("AutomationTest");
		PropertyConfigurator.configure("./Log4J\\Log4j.properties");

		driver.get(url);
		driver.manage().window().maximize();
		logs.info("Website opened");
	}

	@Test(priority = 1)
	public void TC1_UserLogin() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			hp.clickSigninButton();
			lp.enterUserId();
			lp.enterUserPwd();
			lp.clickLoginButton();
			hp.verifyLogin();
			logs.info("*User login successful*");
		} catch (Exception e) {
			logs.error("!User could not log in!");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority = 2)
	public void TC2_AddToWishList() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
		hp.clickDressesSection();
		pp.selectRequiredProduct();
		pp.verifyProductSelected();
		pp.clickWishListButton();
		logs.info("*Product successfully added to wishlist*");
		} catch (Exception e) {
			logs.error("!Failed to add product to wishlist!");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
