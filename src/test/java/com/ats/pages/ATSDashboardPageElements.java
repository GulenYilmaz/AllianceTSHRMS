package com.ats.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.testbase.BaseClass;
import com.ats.utils.CommonMethods;



public class ATSDashboardPageElements extends CommonMethods{

	@FindBy(xpath="//a[@class='dropdown-toggle']")
	public WebElement adminLogo;
	
	@FindBy(xpath="//a[@class='sidebar-collapse-icon']")
	public WebElement sidebar;
	
	@FindBy (xpath="//span[text()='Dashboard']")
	public WebElement dashboard;
	
	@FindBy (xpath="//span[text()='Course Management']")
	public WebElement courseManagement;
	
	@FindBy (xpath="//span[text()='Teacher Management']")
	public WebElement teacherManagement;
	
	@FindBy (xpath="//span[text()='Student Management']")
	public WebElement studentManagement; 
	
	@FindBy (xpath="//span[text()='User Management']")
	public WebElement userManagement; 	
	
	@FindBy (xpath="//span[text()='Todo']")
	public WebElement todo;
	
	 public ATSDashboardPageElements() {
		 PageFactory.initElements(BaseClass.driver, this);
	 }
}
