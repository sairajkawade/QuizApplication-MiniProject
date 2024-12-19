package com.admin.addquestions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.dbconnection.DBConnection;

public class AddQuestion {

	// addQuestionAnswer() method use to add the questions and options into the QuestionAnswerDB
	private void addQuestionAnswer(String question, String opt1, String opt2, String opt3, String opt4, String ans) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			DBConnection dbConnection =  new DBConnection();
			con = dbConnection.getConnnection();
			
			// Insert query to add the data into the questionanswerdb table
			ps = con.prepareStatement("Insert into questionanswerdb(Q_ID,que_list,opt1,opt2,opt3,opt4,ans) VALUES (QUESTIONANSWERDB_SEQ.nextval,?,?,?,?,?,?)");
		
			ps.setString(1, question);
			ps.setString(2, opt1);
			ps.setString(3, opt2);
			ps.setString(4, opt3);
			ps.setString(5, opt4);
			ps.setString(6, ans);
			
			ps.executeUpdate();
			System.out.println("\nQuestion is added Successfully...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
			ps.close();
		}
		
	}
	
	// setQuestion() method is used to take question and options as i/p from user
	public void setQuestion() throws SQLException {
	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the question : ");
		String question = sc.nextLine();
		System.out.println("\n Please enter option with prefix ");
		System.out.println("\n like a) option1, b) option2, c) option3, d) option4 ");
		System.out.print("\nEnter Option 1. : ");
		String opt1 = sc.nextLine();
		System.out.print("Enter Option 2. : ");
		String opt2 = sc.nextLine();
		System.out.print("Enter Option 3. : ");
		String opt3 = sc.nextLine();
		System.out.print("Enter Option 4. : ");
		String opt4 = sc.nextLine();
		System.out.print("Enter the correct answer : ");
		String ans = sc.nextLine();
		
		// pass the user's data to the addQuestionAnswer() method to store it into the QuestionAnswerDB 
		addQuestionAnswer(question, opt1, opt2, opt3, opt4, ans); // method calling
	}
}

