package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Boundary.AdminHandlerMenu;

import Entity.Camp;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;
import Manager.EnquiriesManager;
/**
 * The CampCommitteeEnquiryHandler class provides methods for handling enquiries by camp committee members.
 * Camp committee members can only view and process camps that they are in charge of.
 * It allows committee members to view and reply to enquiries from students.
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */
public class CampCommitteeEnquiryHandler implements AdminHandlerMenu{
    static Scanner sc = new Scanner(System.in);
	/**
	 * Displays the list of enquiries for the camp committee's camp.
	 * Committee members can view and reply to enquiries from students.
	 *
	 * @param aStudent The student who is a camp committee member.
	 */
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
	/**
	 * Processes the reply to an enquiry by a camp committee member.
	 * If the enquiry has not been processed, the committee member can provide a reply.
	 * If the enquiry has been processed, the committee member cannot provide a reply.
	 * The reply is then stored, and the enquiry is marked as processed.
	 *
	 * @param aStudent The student who is a camp committee member.
	 * @param enquiry  The specific enquiry to reply to.
	 */
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
