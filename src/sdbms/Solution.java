package sdbms;
import customexecption.*;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to Student DB Management System");
		System.out.println("--------------------------------------------");

		Scanner ip=new Scanner(System.in);
		StudentManagementSystem s= new StudentManagementSystemImpl();
		while(true) {
			System.out.println("1.Add student data\n2.displayStudent\n3.displayAllStudent\4.removeStudent");
			System.out.println("5.removeAllStudents\n6.updateStudent\n7.countStudent\n8.sortStudent\n9.getStudentWithLowestMarks\n10.getStudentWithHighestMarks\n11.Exit\n");
			System.out.println("Enter your choice ");
			int key=ip.nextInt();
			switch (key) {
			case 1: 
				s.addStudent();
				break;
			case 2:
				s.displayStudent();
				break;
			case 3:
				s.displayAllStudent();
				break;
			case 4:
				s.removeStudent();
				break;
			case 5:
				s.removeAllStudents();
				break;
			case 6:
				s.updateStudent();
				break;
			case 7:
				s.countStudent();
				break;
			case 8:
				s.sortStudent();
				break;
			case 9:
				s.getStudentWithLowestMarks();
				break;
			case 10:
				s.getStudentWithHighestMarks();
				break;
			case 11:
				System.out.println("Thank you!!");
				System.exit(0);
				break;
			default:
				try {
					throw new InvalidChoiceExecption("Invalid choice, Enter the valid choice");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}//end of switch
			}// end of while loop
			System.out.println("--------------------------------------------------");
		}
	}// end of main method

}// end of class
