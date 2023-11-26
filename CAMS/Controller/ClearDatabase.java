package Controller;

import Entity.CampDatabase;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;
/**
 * The ClearDatabase class provides methods to clear all data.
 * It clears all camps, enquiries, staff, students, and suggestions.
 * This class is used when the user wants to restart the program from a fresh start.
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */
public class ClearDatabase {
    /**
     * Clears all data from the database, for camps, enquiries, staff, students, and suggestions.
     */
    public static void clearAll(){
        CampDatabase c=new CampDatabase();
        c.clearCamps();
        EnquiriesManager e=new EnquiriesManager();
        e.clearEnquiries();
        StaffManager s=new StaffManager();
        s.clearStaffs();
        StudentManager sM=new StudentManager();
        sM.clearStudents();
        SuggestionsManager sg=new SuggestionsManager();
        sg.clearSuggestion();
    }
}
