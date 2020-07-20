/* ConnectionUtil.java */

package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");			
		} //end try block
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} //end catch block
		
		String url = "jdbc:postgresql://localhost:5432/ROCP1BankingAPI";
		String username = "postgres";
		String password = "XXXXXXXXXXX";
		
		return DriverManager.getConnection(url, username, password);
	
	} //end getConnection method
	
} //end of ConnectionUtil class
