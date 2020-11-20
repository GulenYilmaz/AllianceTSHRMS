package com.ats.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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


	
	/**
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		element.click();
	}
	
	
	/**
	 * Method that checks if text is there and then selects it
	 *
	 * @param element
	 * @param textToSelect
	 */
	public static void selectDDValue (WebElement element , String text) {
		
		Select select=new Select(element);
		List<WebElement> options= select.getOptions();
		for(WebElement el:options) {
			if(el.getText().equals(text)){
				select.selectByVisibleText(text);
				break;
			}
		}
		
	}
		/**
		  Method that selects value by index
	 *
	 * @param element
	 * @param index
	 */
		public static void selectDDValue(WebElement element, int index){
			
			Select select=new Select(element);
			int size=select.getOptions().size();
			
			if(size>index) {
				select.selectByIndex(index);
			}
			}
		
	
		
		
		
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	

