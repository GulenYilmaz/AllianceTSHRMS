package com.ats.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class DatabaseTestAutomation {

	String dbUsername = "syntax_lms";
	String dbPassword = "syntaxlms123";
	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://3.84.255.51:3306/syntax_lms";

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	@Given("I create connection with LMS database")
	public void i_create_connection_with_LMS_database() throws SQLException {
		connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

	}

	@Given("I create a statement")
	public void i_create_a_statement() throws SQLException {
		statement = connection.createStatement();

	}

	@When("I retrive all users from LMS database")
	public void i_retrive_all_users_from_LMS_database() throws SQLException {
		String query = "select * from users";
		resultSet = statement.executeQuery(query);
	}

	@Then("I validate results for  users")
	public void i_validate_results_for_users(DataTable dataTable) throws SQLException {

		List<Map<String, String>> expectedResult = dataTable.asMaps();

		Iterator<Map<String, String>> it = expectedResult.iterator();
		resultSet.next();

		while (it.hasNext()) {

			Map<String, String> expectedKeyResults = it.next();

			String expectedKeys = expectedKeyResults.get("user name");// table column name

			String actualKeys = resultSet.getString("user name");

			Assert.assertEquals(expectedKeys, actualKeys);
		}

	}

	@Then("I close all connections")
	public void i_close_all_connections(io.cucumber.datatable.DataTable dataTable) throws SQLException {
		resultSet.close();
		statement.close();
		connection.close();
	}

}
