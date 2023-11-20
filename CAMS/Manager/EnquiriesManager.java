package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*;
import Entity.Camp;
import Entity.Enquiry;
import Serializer.*; 

public class EnquiriesManager {
    private static ArrayList<Enquiry> enquiries;
    static EnquiriesSerializer s = new EnquiriesSerializer();


public EnquiriesManager() {

    enquiries = EnquiriesSerializer.getEnquiries("EnquiriesDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (enquiries == null) {
        enquiries = new ArrayList<Enquiry>();
        }
}

public void addEnquiry(Enquiry newEnquiry) {
    enquiries.add(newEnquiry);
    EnquiriesSerializer.saveEnquiries(enquiries, "EnquiriesDatabase.ser");
    System.out.println("Enquiries Successfully Saved.");
}
public static ArrayList<Enquiry> getEnquiry() {
		System.out.println("Retrieving Enquiries.");
		return enquiries;
	}
public void clearEnquiries() {
    // Clear the student list
    this.enquiries.clear();

    // Save the empty list to the serialized file
    EnquiriesSerializer.saveEnquiries(enquiries, "EnquiriesDatabase.ser");
    //System.out.println("Enquiries Database Cleared.");
}
} 
