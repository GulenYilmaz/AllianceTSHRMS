package com.ats.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.ats.utils.ConfigsReader;
import com.ats.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	// System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
	public static WebDriver driver;

	/**
	 * 
	 */
	public static WebDriver setUp() {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser in not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

		driver.get(ConfigsReader.getProperty("url"));
		PageInitializer.initialize();
		
		return driver;

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
