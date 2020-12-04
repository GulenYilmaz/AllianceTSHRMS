package DatabaseMySQLvalidation;

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

import org.junit.Test;

public class EnhancedDataStoring {

	String dbUsername = "syntax_lms";
	String dbPassword = "syntaxlms123";
	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://3.84.255.51:3306/syntax_lms";

	@Test
	public void StoreDataInsideLIstFromMap() throws SQLException {

		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");

		Statement statement = connection.createStatement();
		String sqlQuery = "select * from users";
		ResultSet resultset = statement.executeQuery(sqlQuery);

		ResultSetMetaData resultsetMetaData = resultset.getMetaData();
		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> mapData;

		while (resultset.next()) {

			mapData = new LinkedHashMap<>();

			for (int i = 1; i <= resultsetMetaData.getColumnCount(); i++) {
				mapData.put(resultsetMetaData.getColumnName(i), resultset.getObject(i).toString());
			}
			listData.add(mapData);
		}
		System.out.println(listData);
	}

}
