package com.ats.utils;

import org.openqa.selenium.WebElement;

public class CommonMethods {

	public static void sendText(WebElement element, String text){
		element.clear();
		element .sendKeys(text);
	}	
	
	
}
