package DatabaseMySQLvalidation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataMySQLvalidation {

	String dbUsername = "syntax_lms";
	String dbPassword = "syntaxlms123";
	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://3.84.255.51:3306/syntax_lms";
	String sqlQuery = "select * from users";

	@Test

	public void dbMetadata() throws SQLException {

		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData = connection.getMetaData();// ---> get database information

		String driverName = dbMetaData.getDriverName();
		String databaseVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(driverName + " database version : " + databaseVersion);

	}

	@Test
	public void resultSetMetadata() throws SQLException {
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");

		Statement statement = connection.createStatement();
		String sqlQuery = "select * from users";
		ResultSet resultset = statement.executeQuery(sqlQuery);

		ResultSetMetaData resultSetMetaData = resultset.getMetaData();//---> get  table information
		int columnNumber= resultSetMetaData.getColumnCount();
		System.out.println(columnNumber);
		
		String columnNames= resultSetMetaData.getColumnName(columnNumber);
		System.out.println(columnNames);
		
		for(int i=1; i<=columnNumber; i++ ) {
			String columnNmames= resultSetMetaData.getColumnName(i);
			System.out.println(columnNames);
		}
		
	}

}
