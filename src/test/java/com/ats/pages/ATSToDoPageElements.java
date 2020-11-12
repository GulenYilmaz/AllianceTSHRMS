package com.ats.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.testbase.BaseClass;
import com.ats.utils.CommonMethods;

public class ATSToDoPageElements extends CommonMethods{

	
	@FindBy (xpath="//img[@class='img-circle']")
	public WebElement ToDologo;
		
	@FindBy (xpath="//button[@class='btn btn-danger']")
	public WebElement TodoLogout;
		
	
	public ATSToDoPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
