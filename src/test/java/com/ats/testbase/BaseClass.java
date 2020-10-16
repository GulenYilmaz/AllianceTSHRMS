package com.ats.testbase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ats.utils.ConfigsReader;
import com.ats.utils.Constants;

public class BaseClass {
	public static WebDriver driver;

	/**
	 * 
	 */
	public static void setUp() {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperties("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser in not supported");
		}
		driver.get(ConfigsReader.getProperties("url"));
	}

	/**
	* 
	*/
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
