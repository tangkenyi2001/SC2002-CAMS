package Controller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import Entity.Camp;
import Entity.Student;

public class GenerateHandler {

	public  static void generateReport(Camp camp) throws IOException{
		int choice;	
		int i=0;
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("Generate List");
			System.out.println("(1) Attendee");
			System.out.println("(2) Camp Committee");
			System.out.println("(3) All Students");
			System.out.println("(4) Enquiries");
			choice=sc.nextInt();
		}while (choice <1 || choice >4);
		switch (choice) {
			case 1:
				GenerateAttendees.generateReport(camp);
				break;
			case 2:
				GenerateCampCommittee.generateReport(camp);
				break;
			case 3:
				GenerateAll.generateReport(camp);
				break;
			case 4:
				GenerateEnquiry.generateReport(camp);
				break;
			default:
				break;
		}
		
		
		

	}

}