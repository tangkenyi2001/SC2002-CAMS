package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*; 

import Serializer.*; 

public class EnquiriesManager {
    private ArrayList<Enquiries> enquiries;
    static EnquiriesSerializer s = new EnquiriesSerializer();


public EnquiriesManager() {

    enquiries = EnquiriesSerializer.getEnquiries("EnquiriesDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (enquiries == null) {
        enquiries = new ArrayList<Enquiries>();
        }
}

public void addEnquiry(Enquiries newEnquiry) {
    enquiries.add(newEnquiry);
    EnquiriesSerializer.saveEnquiries(enquiries, "EnquiriesDatabase.ser");
    System.out.println("Enquiries Successfully Saved.");
}

} 
