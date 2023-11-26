package Controller;

import Entity.CampDatabase;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;

public class ClearDatabase {
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
