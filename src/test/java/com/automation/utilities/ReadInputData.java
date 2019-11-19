package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//This class maintains the methods to read variables from 'properties'file places inside 'ínputdata'folder

public class ReadInputData {

	public Properties prop;

	public ReadInputData() { // Constructor to initialize file for reading
		File fl = new File("./InputData/inputdata.properties");
		try {
			FileInputStream fs = new FileInputStream(fl);
			prop = new Properties();
			prop.load(fs);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getBrowserName() {
		String browsername = prop.getProperty("browser");
		return browsername;
	}
	
	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}

	public String getChromeDriverPath() {
		String chromedriver = prop.getProperty("chromedriverpath");
		return chromedriver;
	}

	public String getFirefoxDriverPath() {
		String firefoxdriver = prop.getProperty("firefoxdriverpath");
		return firefoxdriver;
	}

	public String getIeDriverPath() {
		String iedriver = prop.getProperty("iedriverpath");
		return iedriver;
	}
	
	public String getUserName() {
		String uname = prop.getProperty("username");
		return uname;
	}

	public String getUserEmail() {
		String email = prop.getProperty("useremail");
		return email;
	}

	public String getUserPassword() {
		String password = prop.getProperty("userpassword");
		return password;
	}
	
	public String getProductWanted() {
		String product = prop.getProperty("productwanted");
		return product;
	}
}
