package Manager;

import java.util.*;
import java.io.*;  
import java.util.ArrayList;
import Controller.*; 
import Entity.*;
import Serializer.*; 

public class StaffManager {
    private ArrayList<Staff> staffs;
    static StaffSerializer s = new StaffSerializer();


public StaffManager() {

    staffs = StaffSerializer.getStaffs("StaffDatabase.ser"); // not sure if it should be StaffSerializer here or s (TBC) // 
    if (staffs == null) {
        staffs = new ArrayList<Staff>();
        }
}

public void addNewStaff(Staff newStaff) {
    staffs.add(newStaff);
    StaffSerializer.saveStaffs(staffs, "StaffDatabase.ser");
    //System.out.println("Staff Successfully Saved.");
}
public ArrayList<Staff> getStaff(){
    return this.staffs;
}
public void updateStaff(Staff staff){
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
public void clearStaffs() {
    // Clear the staffs list
    this.staffs.clear();

    // Save the empty list to the serialized file
    StaffSerializer.saveStaffs(staffs, "StaffDatabase.ser");
    //System.out.println("Staff Database Cleared.");
}

} 