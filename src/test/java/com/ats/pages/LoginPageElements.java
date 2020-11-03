package com.ats.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.testbase.BaseClass;

public class LoginPageElements extends BaseClass{

	@FindBy(id="user_email")
	public WebElement adminEmail;
	
	@FindBy(id="user_password")
	public WebElement adminPassword;
	
	@FindBy(xpath="//button [@type='submit']")
	public WebElement loginBtn;
	
	
	
	public LoginPageElements () {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
