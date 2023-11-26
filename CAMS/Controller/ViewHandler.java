package Controller;
import java.time.LocalDate;
import java.util.*;
import Entity.Camp;
import Entity.CampDatabase;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;
/**
 * Takes care of viewing interface requirements for list of camps and enquiries
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class ViewHandler {
	/**
	 * Prints list of camps that user can register for based on the camp's visibility and faculty group
	 * Also checks if student has already registered for camp, if so, will not show up on interface
	 * @param student Currently logged in user
	 * @return An array list of camps to extract camp that user selects
	 */
	public static ArrayList<Camp> viewRegisterAvailable(Student student){
		LocalDate currentLocalDate = java.time.LocalDate.now();
		ArrayList<Camp> campList = CampDatabase.getCamp();
		ArrayList<Camp> availableCamps = new ArrayList<Camp>();
		Camp camp;
		int j=0;
		for(int i = 0; i < campList.size(); i++){
			camp = campList.get(i);
			LocalDate campDeadline = camp.getCampInfo().getDeadline();
			if(currentLocalDate.isBefore(campDeadline)){
				if(((student.getFaculty().toUpperCase().equals(camp.getCampInfo().getUserGroup()) && !student.getRegisteredCamps().contains(camp)) || (camp.getCampInfo().getUserGroup().equals("ANY") && !student.getRegisteredCamps().contains(camp))) && camp.getVisibility()){
					System.out.println("("+ (++j) + ") " + camp.getCampInfo().getCampName());
					availableCamps.add(camp);
					Updater.updateAll(null, student, null, null, camp);
				}
			}
		}
		return availableCamps;
	}
	/**
	 * Prints list of camps that student can submit enquiries for
	 * Should include available and already registered camps
	 * @param student Currently logged in user
	 * @return An array list of camps to extract camp that user selects
	 */
	public static ArrayList<Camp> viewEnquiryAvailable(Student student){	// Prints out the camps available to student, and returns the ArrayList of camp
		ArrayList<Camp> campList = CampDatabase.getCamp();
		ArrayList<Camp> availableCamps = new ArrayList<>();
		Camp camp;
		for(int i = 0; i < campList.size(); i++){	// Initialising the arraylist of camps that is available to student
			camp = campList.get(i);
			if((student.getFaculty().equalsIgnoreCase(camp.getCampInfo().getUserGroup())  || camp.getCampInfo().getUserGroup().equals("ANY")) && camp.getVisibility()){
				availableCamps.add(camp);
			}
		}
		for (int j=0; j<availableCamps.size();j++){		// printing out for student to see and choose
			System.out.println("(" + (j+1) + ")" + availableCamps.get(j).getCampInfo().getCampName());
		}
		return availableCamps;
	}
	/**
	 * Prints list of camps that user has not registered for but can
	 * Also prints camp committee slots and attendee slots
	 * @param student Currently logged in user
	 */
	public static void viewAvailableSlots(Student student){
		ArrayList<Camp> campList = CampDatabase.getCamp();
		ArrayList<Camp> myAvailable = new ArrayList<Camp>();
		Camp camp;
		if (campList.size()==0){
			System.out.println("No Camps Available");
			return;
		}
		int j=0;
		for(int i = 0; i < campList.size(); i++){
			camp = campList.get(i);
			if(camp.getVisibility()){
				if(((student.getFaculty().equalsIgnoreCase(camp.getCampInfo().getUserGroup()) && !student.getRegisteredCamps().contains(camp))|| (camp.getCampInfo().getUserGroup().equals("ANY") && !student.getRegisteredCamps().contains(camp)))){
					System.out.println("("+ (++j) + ") " + camp.getCampInfo().getCampName());
					System.out.println("Available attendee slots: " + camp.getCampInfo().getAttendeeSlots());
					System.out.println("Available committee slots: " + camp.getCampInfo().getCommitteeSlots());
					myAvailable.add(camp);
				}
			}
			
		}
		if (myAvailable.isEmpty()){
				System.out.println("No Camps Available");
			}
	}
	/**
	 * Prints all created camps
	 */
	public static void viewAll() {
		int i=0;
		ArrayList<Camp> camps;
		camps = CampDatabase.getCamp(); 
		if (camps.isEmpty()) {
            System.out.println("There are currently no camps created.");
        } else {
            System.out.println("List of all camps:");
            for (Camp camp : camps) {
				i +=1;
                System.out.println("(" + i + ")" + " Camp Name: " + camp.getCampInfo().getCampName());
			}
		}
	}
	/**
	 * View all enquiries that student has submitted
	 * Also includes reply if available
	 * @param student Currently logged in user
	 */
	public static void viewEnquiries(Student student) {
		if (student.getEnquiries().isEmpty()){ System.out.println("You have not submitted any enquiries!"); return;}
		for(int i = 0; i < student.getEnquiries().size(); i++){
			Enquiry enquiry = student.getEnquiries().get(i);
			System.out.println("(" + (i+1)+") "+ "For Camp "+enquiry.getCamp().getCampInfo().getCampName() + ": [" + enquiry.getContent() + "]");
			if(enquiry.getReply() != null){
				System.out.println("Reply: " + enquiry.getReply());
			}
		}	
	}
	/**
	 * View all enquiries submitted for specific camp
	 * Also includes reply if available
	 * @param camp Camp to view enquiries for
	 */
	public static void viewEnquiries(Camp camp) {
		for(int i = 0; i < camp.getEnquiries().size(); i++){
			Enquiry enquiry = camp.getEnquiries().get(i);
			System.out.println((i+1) + " " + enquiry.getContent());
			if(enquiry.getReply() != null){
				System.out.println("Reply: " + enquiry.getReply());
			}else{
				System.out.println("Reply: NULL");
			}
		}	
	}
}