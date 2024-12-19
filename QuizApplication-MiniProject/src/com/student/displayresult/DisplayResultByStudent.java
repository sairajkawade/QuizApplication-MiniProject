package com.student.displayresult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.dbconnection.DBConnection;

public class DisplayResultByStudent {
	
	// getStudentCredentials() method use print the total score with grade with login 
	private void getStudentCredentials(String uname, String pass) throws SQLException {

		// username, password variables used to store student table's username and password 
		String username=null, password=null, grade = null;
		int score =0;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			DBConnection dbConnection =  new DBConnection();
			con = dbConnection.getConnnection();
			
			// use INNER JOIN to fetch the data from student & Result table
			ps = con.prepareStatement("Select Student.username, Student.s_password, ResultDB.totalscore, ResultDB.grade  from Student INNER JOIN ResultDB on student.stud_id  = ResultDB.fk_studid WHERE username = ? AND s_password = ?");
			ps.setString(1, uname);
			ps.setString(2, pass);

			rs =  ps.executeQuery();

			while (rs.next()) {
				username = rs.getString("USERNAME");
				password = rs.getString("S_PASSWORD");
				score = rs.getInt("totalscore");
				grade = rs.getString("grade");
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}

		if((uname.equals(username)) && pass.equals(password)) {
			System.out.println("\nLogin Successfully...");
		}else {
			System.out.println("\nWrong credentials... again enter the correct credentials\n");
			getStudentResult();
		}

		// print the total score with grade
		System.out.println("\nYour total score is >> "+score+" with "+grade);

	}

	// take Input i.e username & password from user in getStudentResult() method
	public void getStudentResult() throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the username : ");
		String uname = scanner.next();

		System.out.print("Enter the password : ");
		String pass = scanner.next();

		getStudentCredentials(uname,pass); // method calling

	}
}

