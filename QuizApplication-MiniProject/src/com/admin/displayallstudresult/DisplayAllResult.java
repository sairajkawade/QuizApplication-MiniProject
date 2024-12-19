package com.admin.displayallstudresult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dbconnection.DBConnection;

public class DisplayAllResult {
	
	//getStudentResult() used to print Student's first name , last name along with score 
	private void getStudentResult() throws SQLException {

		// username, password variables used to store student table's username and password 
		String fname=null, lname=null;
		int score =0; 
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			DBConnection dbConnection =  new DBConnection();
			con = dbConnection.getConnnection();
			
			// use INNER JOIN to fetch the data from student & Result table
			ps = con.prepareStatement("Select Student.firstname, Student.lastname, ResultDB.totalscore from Student INNER JOIN ResultDB on student.stud_id  = ResultDB.fk_studid Order by ResultDB.totalscore ASC");

			rs =  ps.executeQuery();

			while (rs.next()) {
				fname = rs.getString("firstname");
				lname = rs.getString("lastname");
				score = rs.getInt("totalscore");
				System.out.println("\nFirst name >> "+fname);
				System.out.println("Last name >> "+lname);
				System.out.println("Score >> "+score);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllStudentResult() throws SQLException {
		
		getStudentResult(); // method calling

	}
}
