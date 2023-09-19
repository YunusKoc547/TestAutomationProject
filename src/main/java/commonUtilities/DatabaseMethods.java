package commonUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


public class DatabaseMethods extends AbstractPage{
	
	static File file = new File(System.getProperty("user.dir") + "//src//test//resources//sqlQueries.properties");
	public static FileInputStream fileInput;
	static Properties sqlProp = new Properties();

	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	
	
	
	public static void databaseConnection() throws SQLException, ClassNotFoundException {
		
		// Create Connection
		con = DriverManager.getConnection(connection string);
		
		System.out.println("hi");
		// Create statement
		stmt = con.createStatement();

		
	}
	
	public static void sqlFileInit() {
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			sqlProp.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//0th Index = email address || 1st index = password || 2nd index = first_name || 3rd index = last_name
	public static String[] userInformation() throws SQLException {
		sqlFileInit();
		rs = stmt.executeQuery(sqlProp.getProperty("selectAllFromCredentials"));
		String[] userInfo = new String[5];
		userInfo[0] = prop.getProperty("emailAddressForTesting");
		while(rs.next()) {
			if(rs.getString("email_address").equals(userInfo[0])) {
				userInfo[1] = rs.getString("passwords");
				userInfo[2] = rs.getString("first_name");
				userInfo[3] = rs.getString("last_name");
			}
		}
		return userInfo;
	}
		
	public static void executeDBQueries() throws SQLException {
		
		List<String> list = new ArrayList<>();
		
		sqlFileInit();
		
		String[] split = sqlProp.getProperty("multipleQueries").split("!");
		for (int i = 0; i < split.length; i++) {
			list.add(split[i].trim());
		}
		
		System.out.println(list);

		for (int i = 0; i <list.size()-1; i++) {
			stmt.addBatch(list.get(i));
		}
	
		stmt.executeBatch();
	}
}
