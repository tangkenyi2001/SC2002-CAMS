package Manager;

import java.util.*;
import java.io.*;  
import java.util.ArrayList;
import Controller.*; 
import Entity.*;
import Serializer.*; 
/**
 * Represents a StaffManager.
 * 
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class StaffManager {
    /**
     * Creates an ArrayList of Staff.
     */
    private static ArrayList<Staff> staffs;
    static StaffSerializer s = new StaffSerializer();

/**
* Creates a new StaffManager.
* If ArrayList is empty, will create new ArrayList of Staff. 
*/
public StaffManager() {

    staffs = StaffSerializer.getStaffs("StaffDatabase.ser");  
    if (staffs == null) {
        staffs = new ArrayList<Staff>();
        }
}

/**
* Add a new staff to the ArrayList of staff.
* @param newStaff is the newly created Staff
* newly created staff is added to the StaffDatabase serialized file. 
*/
public static void addNewStaff(Staff newStaff) {
    staffs.add(newStaff);
    StaffSerializer.saveStaffs(staffs, "StaffDatabase.ser");
}
/**
* Gets the ArrayList of staffs.
* @return returns the ArrayList of staffs.
*/
public static ArrayList<Staff> getStaff(){
    return staffs;
}

/**
* Saves the changes made by the staff. 
* @param staff to be updated. 
*/
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
/**
* Clear the ArrayList of staffs. 
*/
public static void clearStaffs() {
    StaffManager.staffs.clear();
    StaffSerializer.saveStaffs(staffs, "StaffDatabase.ser");
}

} 
