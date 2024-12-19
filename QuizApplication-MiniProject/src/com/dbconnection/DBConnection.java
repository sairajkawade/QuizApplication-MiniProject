package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public Connection getConnnection() throws SQLException {
		Connection con = null;
		try {
			// step - 1. loading driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// step-2. Establish Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
