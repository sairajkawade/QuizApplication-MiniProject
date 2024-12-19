package com.student.datainsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.dbconnection.DBConnection;

public class StudentDataInsert {
	// getUserData() method used to add data into student table using JDBC 
	private void getUserData(String fName,String lName, String uName,String password, String city,String eMail, long mNumber ) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			// Calling DBConnection class's method to connect database
			DBConnection dbConnection =  new DBConnection();
			con = dbConnection.getConnnection();
			
			// Insert Query to insert data into student
			ps = con.prepareStatement("INSERT INTO student(STUD_ID,firstname,lastname,username,s_password,city,email,mobilenumber) VALUES(STUDID_SEQ.NEXTVAL,?,?,?,?,?,?,?)");
		
			ps.setString(1, fName);
			ps.setString(2, lName);
			ps.setString(3, uName);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, eMail);
			ps.setLong(7, mNumber);
			
			ps.executeUpdate();
			System.out.println("\nProfile Created Successfully...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			ps.close();
		}
		
	}
	
	public void getStudentFromUser() throws SQLException {

		// in getStudentFromUser() method, take the data from user
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the first name : ");
		String fName = sc.next();
		System.out.print("Enter the last name : ");
		String lName = sc.next();
		System.out.print("Enter the username : ");
		String uName = sc.next();
		System.out.print("Enter the password : ");
		String password = sc.next();
		System.out.print("Enter the city : ");
		String city = sc.next();
		System.out.print("Enter the mail id : ");
		String eMail = sc.next();
		System.out.print("Enter the mobile number : ");
		long mobileNumber = sc.nextLong();
		
		// below pass the user data to method getUserData() to add into student table
		getUserData(fName, lName, uName, password, city, eMail, mobileNumber);
	}
}
