package DatabaseMySQLvalidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.ats.utils.ConfigsReader;

public class JDBCAllianceTekSolution {
	
	String dbUsername = "syntax_lms";
	String dbPassword = "syntaxlms123";
	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://3.84.255.51:3306/syntax_lms";
    String sqlQuery="select * from users";
	
    @Test
	public void AllianceTekSolutionValidation1() throws SQLException {
     Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
     System.out.println("DB connection is successful");
     
     Statement statement= connection.createStatement();
	 ResultSet resultset=statement.executeQuery(sqlQuery);
	 resultset.next();
	 
	 String  USERNAMEfromDATABASE=resultset.getString("user_name");
	 System.out.println(USERNAMEfromDATABASE);
	 System.out.println(resultset);
	 
	 resultset.close();
	 statement.close();
	 connection.close();
	
	
	}

}
