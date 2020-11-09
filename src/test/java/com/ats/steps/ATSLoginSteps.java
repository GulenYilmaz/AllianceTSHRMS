package com.ats.steps;

import com.ats.pages.ATSLoginPageElements;
import com.ats.utils.CommonMethods;
import com.ats.utils.ConfigsReader;

import io.cucumber.java.en.*;

public class ATSLoginSteps extends CommonMethods {

	@Given("user enters valid username and password")
	public void user_enters_valid_username_and_password() throws InterruptedException {
		sendText(ATSLoginPageElements.ATSlogin.adminEmail, ConfigsReader.getProperty("AdminEmail"));
		Thread.sleep(3000);
		sendText(ATSLoginPageElements.ATSlogin.adminPassword, ConfigsReader.getProperty("AdminPassword"));
		Thread.sleep(3000);

	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		click(ATSLoginPageElements.ATSlogin.loginBtn);

		Thread.sleep(3000);
	}
	@Then("user succesfully logged in")
	public void user_succesfully_logged_in() {

		String expectedText = "Admin";
		String actualText = ATSdb.adminLogo.getText();
		if (expectedText.equals(actualText)) {
			System.out.println("test case is passed ");

		} else {
			System.out.println("test case is failed");
		}
	}

}
