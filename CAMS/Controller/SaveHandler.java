package Controller;

import Entity.CampDatabase;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;
import Serializer.CampSerializer;
import Serializer.EnquiriesSerializer;
import Serializer.StaffSerializer;
import Serializer.StudentSerializer;
import Serializer.SuggestionsSerializer;
/**
 * Saves all data
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class SaveHandler {
    /**
     * Initialize all databases
     * Saves data of all databases
     */
    public static void saveData(){
        StudentManager studentManager=new StudentManager();
        StaffManager staffManager=new StaffManager();
        CampDatabase campDatabase=new CampDatabase();
        EnquiriesManager enquiriesManager=new EnquiriesManager();
        SuggestionsManager suggestionsManager=new SuggestionsManager();

        StaffSerializer.saveStaffs(staffManager.getStaff(), "StaffDatabase.ser");
        StudentSerializer.saveStudents(studentManager.getStudents(),"StudentDatabase.ser");
        CampSerializer.saveCamps(CampDatabase.getCamp(),"CampsDatabase.ser");
        EnquiriesSerializer.saveEnquiries(EnquiriesManager.getEnquiry(), "EnquriesDatabase.ser");
        SuggestionsSerializer.saveSuggestions(SuggestionsManager.getSuggestions(), "SuggestionsDatabase.ser");
        

    }
}
