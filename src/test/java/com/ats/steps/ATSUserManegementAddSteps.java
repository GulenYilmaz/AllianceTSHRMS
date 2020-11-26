package com.ats.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.ats.pages.ATSDashboardPageElements;
import com.ats.pages.ATSUserManagementPageElements;
import com.ats.utils.CommonMethods;
import com.ats.utils.Constants;
import com.ats.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ATSUserManegementAddSteps extends CommonMethods {

	@Then("user navigates to UserManagementPage")
	public void user_navigates_to_UserManagementPage() throws InterruptedException {
		ATSDashboardPageElements.ATSdb.userManagement.click();
		Thread.sleep(2000);
	}

	@When("user click add button")
	public void user_click_add_button() throws InterruptedException {

		Thread.sleep(5000);
		ATSUserManagementPageElements.ATSump.addUserButton.click();

	}

	@When("user enter employee name {string}, {string}, {string} and {string}")
	public void user_enter_employee_name_and(String userName, String userEmail, String userContact, String userPassword)
			throws InterruptedException {
		sendText(ATSUserManagementPageElements.ATSump.addUserNameBox, userName);
		Thread.sleep(2000);
		sendText(ATSUserManagementPageElements.ATSump.AddUserEmailBox, userEmail);
		Thread.sleep(2000);
		sendText(ATSUserManagementPageElements.ATSump.addUserContactBox, userContact);
		Thread.sleep(2000);
		sendText(ATSUserManagementPageElements.ATSump.AddUserPasswordBox, userPassword);
		Thread.sleep(2000);

	}

	@Then("user upload a picture {string}")
	public void user_upload_a_picture(String picturePath) throws InterruptedException {
		sendText(ATSUserManagementPageElements.ATSump.userImage, picturePath);
		Thread.sleep(2000);
	}

	@Then("user selects permission to Grades, Courses, Teacher, Student, User Managements ans ToDos")
	public void user_selects_permission_to_Grades_Courses_Teacher_Student_User_Managements_ans_ToDos()
			throws InterruptedException {
		Thread.sleep(2000);
		ATSUserManagementPageElements.ATSump.checkBoxGradesManagement.click();
		Thread.sleep(2000);
		ATSUserManagementPageElements.ATSump.checkBoxCoursesManagement.click();
		Thread.sleep(2000);
		ATSUserManagementPageElements.ATSump.checkBoxTeacherManagement.click();
		Thread.sleep(2000);
		ATSUserManagementPageElements.ATSump.checkBoxStudentManagement.click();
		Thread.sleep(2000);
		ATSUserManagementPageElements.ATSump.checkBoxUserManagement.click();
		Thread.sleep(2000);
		ATSUserManagementPageElements.ATSump.checkBoxToDos.click();
		Thread.sleep(2000);
	}

	@When("user click save changes button")
	public void user_click_save_changes_button() throws InterruptedException {

		ATSUserManagementPageElements.ATSump.AddUserSaveButton.click();
		Thread.sleep(5000);
	}

	@Then("{string} is added successfully")
	public void is_added_successfully(String userFirstname) throws InterruptedException {

		selectDDValue(ATSUserManagementPageElements.ATSump.selectAll, "All");
		Thread.sleep(2000);
		sendText(ATSUserManagementPageElements.ATSump.filterName, userFirstname);
		Thread.sleep(2000);
		String actualEmail = ATSUserManagementPageElements.ATSump.johnEmail.getText();
		Thread.sleep(2000);
		String extpectedEmail = "john@john.com";
		Thread.sleep(2000);
		Assert.assertEquals(extpectedEmail, actualEmail);

	}

	@When("user enter {string}, {string}, {string}, {string}")
	public void user_enter(String Username, String UserEmail, String UserContact, String AssignPassword)
			throws InterruptedException {
		sendText(ATSUserManagementPageElements.ATSump.addUserNameBox, Username);
		Thread.sleep(2000);
		sendText(ATSUserManagementPageElements.ATSump.AddUserEmailBox, UserEmail);
		Thread.sleep(2000);
		sendText(ATSUserManagementPageElements.ATSump.addUserContactBox, UserContact);
		Thread.sleep(2000);
		sendText(ATSUserManagementPageElements.ATSump.AddUserPasswordBox, AssignPassword);
		Thread.sleep(2000);
	}

	@Then("{string}, {string}, {string}, {string} and {string} is added successfully")
	public void and_is_added_successfully(String Username, String UserEmail, String UserContact, String AssignPassword,
			String UploadPicture) {

		System.out.println("Multible users added succesfully");

	}

	// dataTable for just one step
	@When("user enters details and click save button then users are added")
	public void user_enters_details_and_click_save_button_then_users_are_added(DataTable dataTable)
			throws InterruptedException {

		List<Map<String, String>> addUserList = dataTable.asMaps();

		for (Map<String, String> user : addUserList) {
			String expectedUserName = user.get("Username").toString();
			String expectedUserEmail = user.get("UserEmail").toString();
			String expectedUserContact = user.get("UserContact").toString();
			String expectedAssignPassword = user.get("AssignPassword").toString();
			String expectedUploadPicture = user.get("UploadPicture").toString();

			sendText(ATSUserManagementPageElements.ATSump.addUserNameBox, expectedUserName);
			Thread.sleep(2000);
			sendText(ATSUserManagementPageElements.ATSump.AddUserEmailBox, expectedUserEmail);
			Thread.sleep(2000);
			sendText(ATSUserManagementPageElements.ATSump.addUserContactBox, expectedUserContact);
			Thread.sleep(2000);
			sendText(ATSUserManagementPageElements.ATSump.AddUserPasswordBox, expectedAssignPassword);
			Thread.sleep(2000);
			sendText(ATSUserManagementPageElements.ATSump.userImage, expectedUploadPicture);

			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxGradesManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxCoursesManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxTeacherManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxStudentManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxUserManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxToDos.click();
			Thread.sleep(2000);

			ATSUserManagementPageElements.ATSump.AddUserSaveButton.click();

			ATSUserManagementPageElements.ATSump.addUserButton.click();
			Thread.sleep(5000);

		}
	}

	// from excel  
	@When("user enter data from excel sheet {string}")
	public void user_enter_data_from_excel_sheet(String adduserfromexcelsheet) throws InterruptedException {

		List<Map<String, String>> excelDataList = ExcelUtility.dataFromExcelFile(Constants.EXCEL_FILEPATH, adduserfromexcelsheet);
		
		for (Map<String, String> data : excelDataList) {

			// get data from excel
			String username = data.get("Username");
			String useremail = data.get("UserEmail");
			String usercontact = data.get("UserContact");
			String userpassword = data.get("AssignPassword");
			String uploadPicture = data.get("UploadPicture");

			// sent user data from excel
			sendText(ATSUserManagementPageElements.ATSump.addUserNameBox, data.get("Username"));
			Thread.sleep(2000);
			sendText(ATSUserManagementPageElements.ATSump.AddUserEmailBox, data.get("UserEmail"));
			Thread.sleep(2000);
			sendText(ATSUserManagementPageElements.ATSump.addUserContactBox, data.get("UserContact"));
			Thread.sleep(2000);
			sendText(ATSUserManagementPageElements.ATSump.AddUserPasswordBox, data.get("AssignPassword"));
			Thread.sleep(2000);
			sendText(ATSUserManagementPageElements.ATSump.userImage, data.get("UploadPicture"));
			Thread.sleep(2000);

			// click checkboxshh
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxGradesManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxCoursesManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxTeacherManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxStudentManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxUserManagement.click();
			Thread.sleep(2000);
			ATSUserManagementPageElements.ATSump.checkBoxToDos.click();
			Thread.sleep(2000);

			ATSUserManagementPageElements.ATSump.AddUserSaveButton.click();
			Thread.sleep(5000);

		}

	}

	@Then("user is succesfully added")
	public void user_is_succesfully_added() {
		System.out.println("Multible users added succesfully");

	}	
	
}
