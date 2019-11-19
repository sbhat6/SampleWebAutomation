package com.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automation.utilities.ReadInputData;

public class DriverSetup { //Separating driver setup to achieve code re-usability

	ReadInputData rd = new ReadInputData(); //Reading input variables from '.properties'file placed at InputData/inputdata.properties

	public String browser = rd.getBrowserName();
	public String url = rd.getUrl();
	public String chromepath = rd.getChromeDriverPath();
	public String firefoxpath = rd.getFirefoxDriverPath();
	public String iepath = rd.getIeDriverPath();
	public String username = rd.getUserName();
	public String useremail = rd.getUserEmail();
	public String userpassword = rd.getUserPassword();
	public String productwanted = rd.getProductWanted();

	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {	

		try {  //Initializing WebDriver based on the browser name passed in the properties file present in InputData folder

			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromepath);
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", firefoxpath);
				driver = new FirefoxDriver();
			} else if (browser.equals("ie")) {
				System.setProperty("webdriver.ie.driver", iepath);
				driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (NullPointerException ex) {
			throw new RuntimeException("Selenium driver could not be initialised at this time; Exception occurred");
		}

	}

	@AfterTest
	public void driverKill() throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
