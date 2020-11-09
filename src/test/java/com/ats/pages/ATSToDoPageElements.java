package com.ats.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.testbase.BaseClass;

public class ATSToDoPageElements {

	
	@FindBy (xpath="//img[@class='img-circle']")
	public WebElement ToDologo;
		
	@FindBy (xpath="//button[@class='btn btn-danger']")
	public WebElement TodoLogout;
		
	
	public ATSToDoPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
