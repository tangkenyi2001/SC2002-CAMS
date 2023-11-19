package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Boundary.StaffHandlerMenu;
import Entity.Camp;
import Entity.Enquiry;
import Entity.Staff;

public class StaffEnquiryHandler implements StaffHandlerMenu{
    static Scanner sc = new Scanner(System.in);

    public static void view(Staff aStaff, int index){
		ArrayList<Camp> createdCamps = aStaff.getCreatedCamps();
		Camp aCamp = createdCamps.get(index);
		ArrayList<Enquiry> thisEnquiry = aCamp.getEnquiries();
		if(thisEnquiry.isEmpty())
            System.out.println("No enquiries yet.");
		else{
            System.out.println("List of enquiries:");
			for (int i=0; i<thisEnquiry.size(); i++) {
				Enquiry curr = thisEnquiry.get(i);
				System.out.println("("+(i+1)+") "+curr);
			}
		System.out.println("Which enquiry would you like to reply to?");
		int choice = sc.nextInt() - 1;
		process(thisEnquiry.get(choice));
		}	
	}

    private static void process(Enquiry enquiry) {
		if(!enquiry.getProcessed()){
			System.out.println("Enter reply: ");
			String newReply = sc.next();
			enquiry.setReply(newReply);
		}else{
			System.out.println("Enquiry has been processed, unable to reply.");
		}
	}
}
