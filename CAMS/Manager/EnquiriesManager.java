package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*;
import Entity.Camp;
import Entity.Enquiry;
import Entity.Student;
import Serializer.*; 
/**
 * Represents an EnquiryManager.
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class EnquiriesManager {
    /**
     * ArrayList consisting of list of enquiries.
     */
    private static ArrayList<Enquiry> enquiries;
    static EnquiriesSerializer s = new EnquiriesSerializer();


public EnquiriesManager() {
    /**
     * Creates a new EnquiriesManager.
     */
    enquiries = EnquiriesSerializer.getEnquiries("EnquiriesDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (enquiries == null) {
        enquiries = new ArrayList<Enquiry>();
        }
}
     /**
     * Add enquiry to list of enquiries.
     * Saves the new enquiry to the EnquiriesDatabase serialized file
     * @param Enquiriy to be added.
     */

public static void addEnquiry(Enquiry newEnquiry) {
    enquiries.add(newEnquiry);
    EnquiriesSerializer.saveEnquiries(enquiries, "EnquiriesDatabase.ser");
   // System.out.println("Enquiries Successfully Saved.");
}
     /**
     * Gets list of enquiries.
     * 
     * @return ArrayList of enquiries.
     */
public static ArrayList<Enquiry> getEnquiry() {
		//System.out.println("Retrieving Enquiries.");
		return enquiries;
	}

     /**
     * Clears the list of enquiries.
     * Saves the empty list back to the EnquiriesDatabase serialized file
     */

public static void clearEnquiries() {
    enquiries.clear();
    EnquiriesSerializer.saveEnquiries(enquiries, "EnquiriesDatabase.ser");
}

     /**
     * Updates the list of enquiries.
     * @param Enquiry to be updated is saved to the ArrayList of enquiries.
     */

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
