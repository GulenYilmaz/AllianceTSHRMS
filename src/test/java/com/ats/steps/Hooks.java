package com.ats.steps;

import com.ats.testbase.BaseClass;
import com.ats.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before 
	public  void start() {
		BaseClass.setUp();
	} 
	
	@After
	public void end(Scenario scenario) {
		byte[] picture;
		if (scenario.isFailed()) {
			picture=CommonMethods.takeScreenshot("Failed/"+scenario.getName());
		}else {
			picture=CommonMethods.takeScreenshot("Passed/"+scenario.getName());
		}
		
		
		scenario.attach(picture, "image/png", scenario.getName());
		
		BaseClass.tearDown();
	}
}
