package Controller;

import Entity.CampDatabase;
import Manager.CsvReader;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;
/**
 * Handles initialization of databases
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class LoadDataHandler {
    /**
     * Initializes database
     */
    public static void loaddata() {
        StudentManager studentManager=new StudentManager();
        StaffManager staffManager=new StaffManager();
        CampDatabase campDatabase=new CampDatabase();
        EnquiriesManager enquiriesManager=new EnquiriesManager();
        SuggestionsManager suggestionsManager=new SuggestionsManager();
        //make sure only initialised once
        if (staffManager.getStaff().isEmpty()&&studentManager.getStudents().isEmpty()){
            CsvReader.readstaff();
            CsvReader.readstudent();
            System.out.println("Database has been initialised"); 
        }
        else{
            System.out.println("Database has already been initialised");
        }
        
    }
}
