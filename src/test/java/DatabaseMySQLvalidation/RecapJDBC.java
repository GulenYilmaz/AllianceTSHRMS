package DatabaseMySQLvalidation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;



public class RecapJDBC {
	//JDBC Java database Connectivity
	
	
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	
//	Connection for MySQL Workbench
//	Hostname:3.84.255.51
//	port:3306
//	username:syntax_lms
//	password: syntaxlms123 
//	DatabaseName:syntax_lms
//	dbURL=jdbc:mysql://3.84.255.51:3306/syntax_lms

	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	
	
//	import java.sql.Connection;
//	import java.sql.DatabaseMetaData;
//	import java.sql.DriverManager;
//	import java.sql.SQLException;
	@Test
	public void getConnection() throws SQLException {
		
		
		Connection connection= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	
	//data from database	
	DatabaseMetaData dbMetadata= connection.getMetaData();
	String databaseName=dbMetadata.getDatabaseProductName();
	String databaseVersion=dbMetadata.getDatabaseProductVersion();
	System.out.println("Database name : "+databaseName+ "Database version : "+databaseVersion);
	
	String dbQuery="";
	Statement statement=connection.createStatement();
	ResultSet resultSet=statement.executeQuery(dbQuery);
	
	// data from table
	ResultSetMetaData resultsetMetaData= resultSet.getMetaData();
	int coloumnCount=resultsetMetaData.getColumnCount();
	String columnName=resultsetMetaData.getColumnName(1);//first column name
	
	
	for(int i=1; i<=resultsetMetaData.getColumnCount();i++) {
		
	}
	
	String firstcolumnName="";
	String secondcolumnName="";
	while(resultSet.next()) {
		firstcolumnName=resultSet.getObject("first column Name From Table").toString();
		secondcolumnName=resultSet.getObject("second column Name From ").toString();
	System.out.println("first column Name"+firstcolumnName+" second column Name"+secondcolumnName);
	}
	  resultSet.close();
	  statement.close();
	  connection.close();
	}
	
}
