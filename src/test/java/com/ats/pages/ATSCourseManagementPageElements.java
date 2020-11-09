package com.ats.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.testbase.BaseClass;
import com.ats.utils.CommonMethods;

public class ATSCourseManagementPageElements extends CommonMethods {

	
	
	@FindBy(id ="add_course")
	public WebElement addBtn;
	
	@FindBy(xpath  ="//button[@class='btn btn-danger']")
	public WebElement logOutBtn;
	
	
	@FindBy(xpath  ="//select[@class='form-control input-sm']")
	public WebElement recordPerPage;
	
	@FindBy(xpath  ="//input[@class='form-control input-sm']")
	public WebElement searchBox;
	
	@FindBy (xpath="//table[@id='all_courses']//thead//tr[2]//th[1]")
	public WebElement srNo;
	
	@FindBy(xpath="//table//thead//tr[2]//th[2]")
	public WebElement courseName;
	
	@FindBy(xpath="//table//thead//tr[2]//th[3]")
	public WebElement courseDetail;
	
	@FindBy(xpath="//table//thead//tr[2]//th[4]")
	public WebElement startDate;
	
	@FindBy(xpath="//table//thead//tr[2]//th[5]")
	public WebElement endDate;
	
	@FindBy(xpath="//table//thead//tr[2]//th[6]")
	public WebElement timing;
	
	@FindBy (xpath="//tbody//tr//td[7]//button[contains(@onclick,'editCourse(1)')]")
	public WebElement editCourse1;
	
	@FindBy (xpath="//tbody//tr//td[7]//button[2][contains(@onclick,'deleteCourse(1)')]")
	public WebElement deleteCourse1;
	
	
	public ATSCourseManagementPageElements (){
		PageFactory.initElements(BaseClass.driver, this);
	}
}
