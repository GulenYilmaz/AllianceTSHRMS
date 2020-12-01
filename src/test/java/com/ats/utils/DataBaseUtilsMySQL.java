package com.ats.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtilsMySQL {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static List<Map<String, String>> listData;

//	String dbUsername = "syntax_hrm";
//	String dbPassword = "syntaxhrm123";
//	jdbc:driver type:hostname:port/db name
//	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	public static void getConnection() {
		try {
			connection = DriverManager.getConnection(ConfigsReader.getProperty("dbURL"),
					ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> storeDataFromDataBase(String sqlQuery) {
		try {
			getConnection();

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			listData = new ArrayList<>();

			while (resultSet.next()) {
				Map<String, String> mapData = new LinkedHashMap<>();

				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

					mapData.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i).toString());

				}
				listData.add(mapData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listData;
	}

	public static void closeConnection() {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
//	    http://elevatelms.syntaxtechs.net/elevatelms/login
//		Admin Email: admin@elevatelms.com
//		Admin Password: 12341234
//		
//	    Simple User with Custom Accessible Modules
//		Email: user_demo1@gmail.com
//		Password: 12341234
//		Student Demo User
//		Email: demo_student1@gmail.com
//		Password: 12341234
//		Teacher Demo User
//		Email: teacher_demo1@gmail.com
//		Password: 12341234

//		Elevate Swagger Documentation:
//		http://ec2-100-25-29-209.compute-1.amazonaws.com/syntaxlms/public/index.php/api/documentation
//		Credentials to access Elevate Live Database (Only readable privileges granted)

//		IP: 100.25.29.209
//		Port: 3306
//		Database Name: syntax_lms
//		username = syntax_lms
//		password = syntaxlms123

//		elevatelms.syntaxtechs.net
//		Alliancetek | Login
//		Syntax LMS
//		elevatelms.syntaxtechs.netelevatelms.syntaxtechs.net
//		Alliancetek | Login
//		Syntax LMS
}

