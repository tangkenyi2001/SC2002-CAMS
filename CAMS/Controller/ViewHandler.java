package Controller;
import java.util.*;

import Entity.Camp;
import Entity.CampDatabase;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;
public class ViewHandler {
	//Prints camps camp can register for
	public static ArrayList<Camp> viewRegisterAvailable(Student student){
		ArrayList<Camp> campList = CampDatabase.getCamps();
		ArrayList<Camp> availableCamps = new ArrayList<>();
		Camp camp;
		for(int i = 0; i < campList.size(); i++){
			camp = campList.get(i);
			if(((student.getFaculty().toUpperCase() == camp.getCampInfo().getUserGroup() && !student.getRegisteredCamps().contains(camp)) || (camp.getCampInfo().getUserGroup().equals("ANY") && !student.getRegisteredCamps().contains(camp))) && camp.getVisibility()){
				System.out.println("("+ (i+1) + ") " + camp.getCampInfo().getCampName());
				availableCamps.add(camp);
			}
		}
		return availableCamps;
	}

	public static ArrayList<Camp> viewEnquiryAvailable(Student student){
		ArrayList<Camp> campList = new ArrayList<>(CampDatabase.getCamps());
		ArrayList<Camp> availableCamps = new ArrayList<>();
		Camp camp;
		for(int i = 0; i < campList.size(); i++){
			camp = campList.get(i);
			if((student.getFaculty().toUpperCase() == camp.getCampInfo().getUserGroup() || camp.getCampInfo().getUserGroup() == "ANY") && camp.getVisibility()){
				System.out.println("("+ (i+1) + ") " + camp.getCampInfo().getCampName());
				availableCamps.add(camp);
			}
		}
		return availableCamps;
	}
	
	public static void viewAvailableSlots(Student student){
		ArrayList<Camp> campList = CampDatabase.getCamps();
		Camp camp;
		if (campList.size()==0){
			System.out.println("No Camps Available");
		}
		else{
			for(int i = 0; i < campList.size(); i++){
			camp = campList.get(i);
			if(((student.getFaculty().toUpperCase().equals(camp.getCampInfo().getUserGroup()) && !student.getRegisteredCamps().contains(camp)) || (camp.getCampInfo().getUserGroup().equals("ANY") && !student.getRegisteredCamps().contains(camp))) && camp.getVisibility()){
				System.out.println("("+ (i+1) + ") " + camp.getCampInfo().getCampName());
				System.out.println("Number of attendee slots: " + camp.getCampInfo().getAttendeeSlots());
				System.out.println("Number of committee slots: " + camp.getCampInfo().getCommitteeSlots());
			}
			}
		}
		
	}
	public static void viewAll() {
		int i=0;
		ArrayList<Camp> camps;
		camps = CampDatabase.getCamps(); 
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

	public void viewEnquiries(Staff staff) {
		// TODO - implement EnquiryHandler.view
		throw new UnsupportedOperationException();
	}

	public static void viewEnquiries(Student student) {
		for(int i = 0; i < student.getEnquiries().size(); i++){
			Enquiry enquiry = student.getEnquiries().get(i);
			System.out.println((i+1) + " " + enquiry.getContent());
			if(enquiry.getReply() != null){
				System.out.println("Reply: " + enquiry.getReply());
			}else{
				System.out.println("Reply: NULL");
			}
		}	
	}

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