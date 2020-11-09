package com.ats.utils;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ats.testbase.PageInitializer;

public class CommonMethods extends PageInitializer{

	/**
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text){
		element.clear();
		element.sendKeys(text);
	}	
	
	
	
	/**
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		element.click();
	}
	
	
	public static void  clickRadioChecbox(List<WebElement> radioOrcheckbox, String value) {
		
		String actualValue;
		for(WebElement el:radioOrcheckbox){
			actualValue=el.getAttribute("value").trim();
			if(el.isEnabled()&& actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}
	
	
	
	
	
	
	
}
