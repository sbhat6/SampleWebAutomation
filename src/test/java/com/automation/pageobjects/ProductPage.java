package com.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.automation.testcases.DriverSetup;

//Page class for product page to maintain the required web elements present on product page along with corresponding methods
public class ProductPage extends DriverSetup {

	public ProductPage(WebDriver driver) { // Constructor to initiate driver object for the page class
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class=product-name]")
	@CacheLookup
	List<WebElement> allProducts;

	public void selectRequiredProduct() {

		int productsCount = allProducts.size();

		for (int i = 0; i < productsCount; i++) {

			if (allProducts.get(i).getText().contains(productwanted)) {
				allProducts.get(i).click();
			}
		}
	}

	@FindBy(xpath = "//div[@id='center_column']/div/div/div[3]/h1")
	@CacheLookup
	WebElement productTitle;

	public void verifyProductSelected() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(productTitle.getText().contains(productwanted), "Wrong product selected!");

	}

	@FindBy(id = "wishlist_button")
	@CacheLookup
	WebElement wishlistButton;

	public void clickWishListButton() throws InterruptedException {
		wishlistButton.click();
	}
}
