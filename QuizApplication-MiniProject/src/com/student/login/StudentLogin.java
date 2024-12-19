package com.student.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.dbconnection.DBConnection;

public class StudentLogin {
	
	// getStudentCredentials() used to student's login validation is right OR wrong
	private int getStudentCredentials(String uname, String pass) throws SQLException {
		
		// username, password variables used to store student table's username and password 
		String username=null, password=null;
		int studentId = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			DBConnection dbConnection =  new DBConnection();
			con = dbConnection.getConnnection();
			
			// fetch username and pasword from student table
			ps = con.prepareStatement("SELECT STUD_ID, USERNAME, S_PASSWORD FROM STUDENT WHERE UserName =? AND s_password =?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			rs =  ps.executeQuery();
			
			// in while() assign student table's data to local variables
			while (rs.next()) {
				studentId = rs.getInt("STUD_ID");
				username = rs.getString("USERNAME");
				password = rs.getString("S_PASSWORD");
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			ps.close();
		}
				
		// check user input (username & password) with student table's data (username & password)
		if((uname.equals(username)) && pass.equals(password)) {
			System.out.println("\nLogin Successfully...");
		}else {
			System.out.println("\nWrong credentials... again enter the correct credentials");
			getUserCredentials(); // if credentials are wrong again it will call getUserCredentials() method 
		}
		
		return studentId;
	}
	
	// take Input i.e username & password from user in getUserCredentials() method
	public int getUserCredentials() throws SQLException {
		
		int i ;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the username : ");
		String uname = scanner.next();
		
		System.out.print("Enter the password : ");
		String pass = scanner.next();
		
		// pass the i/p to getStudentCredentials() method to match with student table data.
		
		i = getStudentCredentials(uname,pass);
		return i;
	}
}
