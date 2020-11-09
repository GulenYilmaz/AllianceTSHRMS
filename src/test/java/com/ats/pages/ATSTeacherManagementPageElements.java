package com.ats.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.testbase.BaseClass;
import com.ats.utils.CommonMethods;

public class ATSTeacherManagementPageElements extends CommonMethods{

	@FindBy (xpath="//button[@class='btn btn-danger']")
	public WebElement logOutBtn;
	
	@FindBy (xpath="//button[@id='add_teacher']")
	public WebElement addTeacherBtn;
	
	public ATSTeacherManagementPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
