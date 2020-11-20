package com.ats.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.testbase.BaseClass;
import com.ats.utils.CommonMethods;

public class ATSUserManagementPageElements extends CommonMethods {
	
	
	@FindBy(xpath = "//select[@class='form-control input-sm']")
	public WebElement selectAll;
	
	@FindBy(xpath = "//button[@id='add_user']")
	public WebElement addUserButton;

	@FindBy(xpath = "//input[@id='user_name']")
	public WebElement addUserNameBox;

	@FindBy(xpath = "//input[@id='user_contact']")
	public WebElement addUserContactBox;

	@FindBy(xpath = "//input[@id='user_email']")
	public WebElement AddUserEmailBox;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement AddUserPasswordBox;
	
	@FindBy(xpath = "//input[@id='user_image']")
	public WebElement userImage;

	
	
	

	@FindBy(xpath = "//input[@value='1']")
	public WebElement checkBoxGradesManagement;

	@FindBy(xpath = "//input[@value='2']")
	public WebElement checkBoxCoursesManagement;

	@FindBy(xpath = "//input[@value='3']")
	public WebElement checkBoxTeacherManagement;

	@FindBy(xpath = "//input[@value='4']")
	public WebElement checkBoxStudentManagement;

	@FindBy(xpath = "//input[@value='5']")
	public WebElement checkBoxUserManagement;

	@FindBy(xpath = "//input[@value='6']")
	public WebElement checkBoxToDos;
	
	@FindBy(xpath = "//button[@class='btn btn-info']")
	public WebElement AddUserSaveButton;
	
	@FindBy(xpath="//input[@value='Name']")
	public WebElement filterName;
	
	@FindBy(xpath="//td[text()='john@john.com']")
	public WebElement johnEmail;

    
	public ATSUserManagementPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}