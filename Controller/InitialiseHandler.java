package Controller;

import Entity.CampDatabase;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;

/**
 * Handles initialization
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class InitialiseHandler {
    /**
     * Checks if databases are loaded
     * Loads data if not
     */
    public static void initialise(){
        StudentManager studentManager=new StudentManager();
        StaffManager staffManager=new StaffManager();
        if (staffManager.getStaff().isEmpty()&&studentManager.getStudents().isEmpty())
        {
            
            System.out.println("Data has not been loaded yet");
            System.out.println("Loading data now...");
            LoadDataHandler.loaddata();

        }
    }
        
}
