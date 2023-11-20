package Controller;

import Entity.CampDatabase;
import Manager.CampManager;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;

public class InitialiseHandler {
    public static void initialise(){
        StudentManager studentManager=new StudentManager();
        StaffManager staffManager=new StaffManager();
        CampDatabase campDatabase=new CampDatabase();
        EnquiriesManager enquiriesManager=new EnquiriesManager();
        SuggestionsManager suggestionsManager=new SuggestionsManager();
        CampManager campManager=new CampManager();
        if (staffManager.getStaff().isEmpty()&&studentManager.getStudents().isEmpty())
        {
            
            System.out.println("Data has not been loaded yet");
            System.out.println("Loading data now...");
            LoadDataHandler.loaddata();

        }
    }
        
}
