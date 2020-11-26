package com.ats.utils;

public class Constants extends CommonMethods{

	public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\configs\\configuration.properties";
	
	
	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
	
	
	public static final int IMPLICIT_WAIT_TIME = 15;
	public static final int EXPLICIT_WAIT_TIME = 30;

	
    public static final String EXCEL_FILEPATH="C:\\Users\\gulen\\eclipse-workspace\\AllianceTekSolution_HRMS_Framework\\src\\test\\resources\\testdata\\ATSAddUsers.xlsx"; 
    public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"\\screenshot\\";
	
	public static void main(String[] args) {

	}
}
