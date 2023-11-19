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

	public  static void generateReport(Camp camp)throws IOException{
		int choice;	
		int i=0;
		File file =new File("out.txt");
		FileWriter fw=new FileWriter(file);
		PrintWriter pw=new PrintWriter(fw);
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("Generate List");
			System.out.println("(1) Attendee");
			System.out.println("(2) Camp Committee");
			choice=sc.nextInt();
		}while (choice <1 || choice >2);

		if (choice==1)//attendee
		{
			pw.println("Camp: " + camp.getCampInfo().getCampName()); // Print camp name
            pw.println("Attendees ");
			for (i=0;i<camp.getAttendees().size();i++){
				pw.print(i+1);
				pw.println(camp.getAttendees().get(i).getName());
			}
			pw.close();


		}

		else{//cc
			pw.println("Camp: " + camp.getCampInfo().getCampName()); // Print camp name
            pw.println("Camp Committee ");
			for (i=0;i<camp.getCommittee().size();i++){
				pw.print(i+1);
				pw.println(camp.getCommittee().get(i).getName());
			}
			pw.close();
		}
		
		

	}

}