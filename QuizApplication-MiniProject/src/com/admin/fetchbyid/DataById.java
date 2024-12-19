package com.admin.fetchbyid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.dbconnection.DBConnection;

public class DataById {
	// getStudentInfo() method is used to pass STUD_ID to the query 
	private void getStudentInfo(int i) throws SQLException {
		
		int score =0;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			DBConnection dbConnection =  new DBConnection();
			con = dbConnection.getConnnection();

			// use INNER JOIN to fetch the data from student & Result table
			ps = con.prepareStatement("Select ResultDB.totalscore from Student INNER JOIN ResultDB on student.stud_id  = ResultDB.fk_studid Where stud_id = ?");
			ps.setInt(1, i);

			rs =  ps.executeQuery();

			while (rs.next()) {
				score = rs.getInt("totalscore");
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Print total score using student id.
		System.out.println("\nScore is : "+score);
	}

	// getStudentId() method is used to take the i/p from user
	public void getStudentId() throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nEnter student id : ");
		int i= scanner.nextInt();

		getStudentInfo(i); // method calling

	}
}