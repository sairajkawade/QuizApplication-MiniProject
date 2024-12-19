package com.quizstart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.dbconnection.DBConnection;
import com.student.login.StudentLogin;

public class StartQuize {

	/* getQuizStart() method used to fetch the question from QUESTIONANSWERDB table
	 * and it is also create a result and store it into the Result table with grade
	 */
	private void getQuizStart() throws SQLException {
		
		int i = 1, score = 0, studId;
		String que, o1, o2, o3, o4 , ans, inString, grade = null; 
		
		// here we need Student Id for work as foregin key into Result table
		StudentLogin studentLogin = new StudentLogin();
		studId = studentLogin.getUserCredentials();		
		System.out.println("Student Id >> " +studId);
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); 
		
		try { // (que_list,opt1,opt2,opt3,opt4,ans)
			DBConnection connection = new DBConnection();
			con = connection.getConnnection();
			
			// Select query to fetc the questions from QUESTIONANSWERDB table
			ps = con.prepareStatement("SELECT * FROM QUESTIONANSWERDB");
			
			rs = ps.executeQuery();
			
			// while() loop use to take data from resultSet aslo it calculate the score
			while (rs.next()) {
				
				que = rs.getString("que_list");
				System.out.println("\nque. "+i+" "+que);
				i++;
				o1 = rs.getString("opt1");
				System.out.println(o1);
				
				o2 = rs.getString("opt2");
				System.out.println(o2);
				
				o3 = rs.getString("opt3");
				System.out.println(o3);
				
				o4 = rs.getString("opt4");
				System.out.println(o4);
				
				ans = rs.getString("ans");
				char ch1 = ans.charAt(0);
				//System.out.println(ch1);
				
				
				System.out.print("\nEnter the answer : ");
				inString =scanner.next();
				char ch2 = inString.charAt(0);
				//System.out.println(ch2);
				
				if(ch1 == ch2) {
					score = score + 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println("Total Score is >> "+score);
		
		// This 'if-else' block use to generate the grade as per score
		if(score >= 15 && score <= 20) {
			grade = "Grade : 'A' >> First class with distinction";
		}else if(score >= 10 && score <= 15) {
			grade = " Grade : 'B' >> First class";
		}else if(score >= 5 && score <= 10) {
			grade = " Grade : 'C' >> Second class ";
		}else if(score >= 1 && score <= 15) {
			grade = "Grade : 'D' >> Third class";
		}
		
		//System.out.println("Your grade is >> "+grade);
		
		Connection con1 = null;
		PreparedStatement ps1 = null;
		
		// Below 'try-catch' block use to store result and grade with stud_id foregin keyinto Result table
		try { //R_ID,TOTALSCORE,GRADE,FK_STUDID

			DBConnection connection = new DBConnection();
			con1 = connection.getConnnection();
			
			//insert query to store Score & grade into Result table
			ps1 = con1.prepareStatement("INSERT INTO ResultDB(R_ID,TOTALSCORE,GRADE,FK_STUDID) VALUES(RES_SEQ.NEXTVAL,?,?,?)");
			ps1.setInt(1, score);
			ps1.setString(2, grade);
			ps1.setInt(3, studId);

			ps1.executeUpdate();
			System.out.println("\nResult stored Successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nThank you...");
	}
	
	
	public void getLogin() throws SQLException {
		
		getQuizStart();
	}
}
