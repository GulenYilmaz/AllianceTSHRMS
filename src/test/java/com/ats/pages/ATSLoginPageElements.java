package com.ats.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.testbase.BaseClass;
import com.ats.utils.CommonMethods;

public class ATSLoginPageElements extends CommonMethods{

	@FindBy(id="user_email")
	public WebElement adminEmail;
	
	@FindBy(id="user_password")
	public WebElement adminPassword;
	
	@FindBy(xpath="//button [@type='submit']")
	public WebElement loginBtn;
	
	
	
	public ATSLoginPageElements () {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
