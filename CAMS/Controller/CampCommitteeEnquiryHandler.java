package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Boundary.AdminHandlerMenu;

import Entity.Camp;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;
import Manager.EnquiriesManager;

public class CampCommitteeEnquiryHandler implements AdminHandlerMenu{
    static Scanner sc = new Scanner(System.in);

    public static void view(Student aStudent){
		Camp aCamp = aStudent.getCampCommittee().getCommitteeOf();
		ArrayList<Enquiry> thisEnquiry = aCamp.getEnquiries();
		if(thisEnquiry.isEmpty())
            System.out.println("No enquiries yet.");
		else{
            System.out.println("List of enquiries:");
			for (int i=0; i<thisEnquiry.size(); i++) {
				Enquiry curr = thisEnquiry.get(i);
				System.out.println("("+(i+1)+") "+curr.getStudent().getName() + ": " +curr.getContent());
				if(curr.getProcessed()){
					System.out.println(curr.getReply());
				}
			}
		System.out.println("Which enquiry would you like to reply to?");
		int choice = sc.nextInt() - 1;
		process(aStudent,thisEnquiry.get(choice));
		}	
	}

    public static void process(Student aStudent, Enquiry enquiry) {
		if(!enquiry.getProcessed()){
			System.out.println("Enter reply: ");
			String newReply = sc.next();
            enquiry.setReplier(aStudent);
			enquiry.setReply(enquiry.getReplier().getName()+": "+newReply);
			enquiry.setProcessedTrue();
            aStudent.getCampCommittee().addPoints();
			Updater.updateAll(enquiry.getCamp().getIC(), enquiry.getStudent(), enquiry, null, enquiry.getCamp());
		}else{
			System.out.println("Enquiry has been processed, unable to reply.");
		}
	}
}
