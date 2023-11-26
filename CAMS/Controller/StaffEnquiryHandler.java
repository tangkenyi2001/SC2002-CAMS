package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Boundary.AdminHandlerMenu;
import Entity.Camp;
import Entity.Enquiry;
import Entity.Staff;
import Entity.User;
import Manager.EnquiriesManager;
/**
 * Takes care of all actions pertaining enquiries for staffs
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class StaffEnquiryHandler implements AdminHandlerMenu{
    static Scanner sc = new Scanner(System.in);
	/**
	 * Prints enquiry of selected created camp of staff
	 * Also provides option to reply to enquiry
	 * @param aStaff Staff user
	 * @param index Index of created camp of staff to view enquiries of
	 */
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
				System.out.println("("+(i+1)+") "+curr.getStudent().getName() + ": " +curr.getContent());
				if(curr.getProcessed()){
					System.out.println(curr.getReply());
				}
			}
		System.out.println("Which enquiry would you like to reply to?");
		System.out.println("Press <0> to cancel");
		int choice = sc.nextInt() - 1;
		if (choice ==-1) return;
		process(aStaff,thisEnquiry.get(choice));
		}	
	}
	/**
	 * Prompts user for reply to enquiry and change processed status
	 * Checks if enquiry has already been processed
	 * @param aStaff Staff user
	 * @param enquiry Enquiry to be processed
	 */
    public static void process(User aStaff,Enquiry enquiry) {
		if(!enquiry.getProcessed()){
			System.out.println("Enter reply: ");
			String newReply = sc.next();
			enquiry.setReply("[Staff]"+aStaff.getName()+": "+newReply);
			enquiry.setProcessedTrue();
			Updater.updateAll(enquiry.getCamp().getIC(), enquiry.getStudent(), enquiry, null, enquiry.getCamp());
		}else{
			System.out.println("Enquiry has been processed, unable to reply.");
		}
	}
}
