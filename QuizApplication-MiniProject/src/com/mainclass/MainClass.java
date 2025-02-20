package com.mainclass;

import java.sql.SQLException;
import java.util.Scanner;
import com.admin.addquestions.AddQuestion;
import com.admin.displayallstudresult.DisplayAllResult;
import com.admin.fetchbyid.DataById;
import com.student.datainsert.StudentDataInsert;
import com.student.displayresult.DisplayResultByStudent;
import com.student.login.StudentLogin;
import com.quizstart.StartQuize;

public class MainClass {
	public static void main(String[] args) throws SQLException{

		// Scanner class - for taking input from users
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int  no = 0;
		// while() loop - if user want executing any option again & again.
		while(no == 0) {
			// printing the below Console Functionalities
			
			System.out.print("Hello this is Quize Application \n");
			
			System.out.println("\n<<<<<<<<<< Quiz Application >>>>>>>>>>\n");
			System.out.println("\nWelcome to Quiz based application");
			System.out.println("\n\t User Operation \n");
			System.out.println("1. Student Registration");
			System.out.println("2. Student Login");
			System.out.println("3. Display the list of questions");
			System.out.println("4. Store Quiz result into database");
			System.out.println("5. Display Quiz result ");
			System.out.println("\n\t Admin Operation \n");
			System.out.println("6. Display all students score as per ascending order");
			System.out.println("7. Fetch student score by using id");
			System.out.println("8. Add question with 4 options into database");
			System.out.println("\n9. Exit");
			System.out.println("----------------------------------------------");
			System.out.print("Enter your choice >> ");
			int index = scanner.nextInt();

			switch (index) { // switch() loop - for user to accept one option.

			case 1: // case 1: Student Registration
				// Your Logic - Only method calling using object of the class
				StudentDataInsert studentDataInsert = new StudentDataInsert();
				studentDataInsert.getStudentFromUser(); // Method calling 
				System.out.println("\n******************************************");
				break;

			case 2: // case 2: for Student Login
				// Your Logic - Only method calling using object of the class
				StudentLogin studentLogin = new StudentLogin();
				studentLogin.getUserCredentials(); // Method calling 
				System.out.println("\n******************************************");
				break;

			case 3: // case 3: Display the list of questions
				StartQuize startQuize = new StartQuize();
				startQuize.getLogin(); // Method calling 
				// Your Logic - Only method calling using object of the class
				System.out.println("\n******************************************");
				break;

			case 4: // case 4: Store Quiz result into database
				System.out.println("\n !!!! Your Quiz result with grade stored Successfully.... !!!!");
				System.out.println("\n******************************************");
				break;

			case 5: // case 5: for Display Quiz result
				// Your Logic - Only method calling using object of the class
				DisplayResultByStudent displayResultByStudent =new DisplayResultByStudent();
				displayResultByStudent.getStudentResult(); // Method calling 	
				System.out.println("\n******************************************");
				break;
				
			case 6: // case 6: for Display all students score as per ascending order
				// Your Logic - Only method calling using object of the class
				DisplayAllResult displayAllResult = new DisplayAllResult();
				displayAllResult.getAllStudentResult();	// Method calling 			 
				System.out.println("\n******************************************");
				break;

			case 7: // case 7: for Fetch student score by using id
				// Your Logic - Only method calling using object of the class
				DataById dataById = new DataById(); 
				dataById.getStudentId(); // Method calling 
				System.out.println("\n******************************************");
				break;

			case 8: // case 8: for Add question with 4 options into database
				// Your Logic - Only method calling using object of the class
				AddQuestion addQuestion = new AddQuestion();
				addQuestion.setQuestion(); // Method calling 
				System.out.println("\n******************************************");
				break;

			case 9: // case 9: for exit from program OR program termination
				System.out.println("\nNow Quiz Application is Turn off...");
				System.out.println("<<< Thank you!!!! >>>");
				System.exit(0); // exit/terminate

			default: // default case : for if user give input except between '1' to '9'
				System.out.println("\nSorry... Inavlid Value ");
				System.out.println("\n******************************************");
				break;
			}
		}
	}
}
