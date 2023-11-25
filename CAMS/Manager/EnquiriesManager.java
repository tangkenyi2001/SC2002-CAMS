package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*;
import Entity.Camp;
import Entity.Enquiry;
import Entity.Student;
import Serializer.*; 

public class EnquiriesManager implements Serializable {
    private static ArrayList<Enquiry> enquiries;
    static EnquiriesSerializer s = new EnquiriesSerializer();


public EnquiriesManager() {

    enquiries = EnquiriesSerializer.getEnquiries("EnquiriesDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (enquiries == null) {
        enquiries = new ArrayList<Enquiry>();
        }
}

public static void addEnquiry(Enquiry newEnquiry) {
    enquiries.add(newEnquiry);
    EnquiriesSerializer.saveEnquiries(enquiries, "EnquiriesDatabase.ser");
   // System.out.println("Enquiries Successfully Saved.");
}
public static ArrayList<Enquiry> getEnquiry() {
		//System.out.println("Retrieving Enquiries.");
		return enquiries;
	}
public static void clearEnquiries() {
    // Clear the student list
    enquiries.clear();

    // Save the empty list to the serialized file
    EnquiriesSerializer.saveEnquiries(enquiries, "EnquiriesDatabase.ser");
    //System.out.println("Enquiries Database Cleared.");
}


public static void update(Enquiry enquiry){
    int i=0;
    for (i=0;i<getEnquiry().size();i++)
                    {
                        if (enquiry.getStudent().equals(getEnquiry().get(i).getStudent()))
                        {
                            getEnquiry().set(i,enquiry);
                        }
                    }
                    EnquiriesSerializer.saveEnquiries(getEnquiry(), "EnquiriesDatabase.ser");
}
} 
