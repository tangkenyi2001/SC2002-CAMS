package Manager;

import java.util.*;
import java.io.*;  
import java.util.ArrayList;
import Controller.*; 
import Entity.*;
import Serializer.*; 

public class StaffManager implements Serializable{
    private static ArrayList<Staff> staffs;
    static StaffSerializer s = new StaffSerializer();


public StaffManager() {

    staffs = StaffSerializer.getStaffs("StaffDatabase.ser"); // not sure if it should be StaffSerializer here or s (TBC) // 
    if (staffs == null) {
        staffs = new ArrayList<Staff>();
        }
}

public static void addNewStaff(Staff newStaff) {
    staffs.add(newStaff);
    StaffSerializer.saveStaffs(staffs, "StaffDatabase.ser");
    //System.out.println("Staff Successfully Saved.");
}
public static ArrayList<Staff> getStaff(){
    return staffs;
}
public static void updateStaff(Staff staff){
    int i=0;
    for (i=0;i<getStaff().size();i++)
                    {
                        if (staff.getName().equals(getStaff().get(i).getName()))
                        {
                            getStaff().set(i,staff);
                        }
                    }
                    StaffSerializer.saveStaffs(getStaff(), "StaffDatabase.ser");
}
public static void clearStaffs() {
    // Clear the staffs list
    StaffManager.staffs.clear();

    // Save the empty list to the serialized file
    StaffSerializer.saveStaffs(staffs, "StaffDatabase.ser");
    //System.out.println("Staff Database Cleared.");
}

} 