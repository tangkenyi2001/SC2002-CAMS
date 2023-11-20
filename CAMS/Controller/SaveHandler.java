package Controller;

import Entity.CampDatabase;
import Manager.CampManager;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;
import Serializer.CampSerializer;
import Serializer.EnquiriesSerializer;
import Serializer.StaffSerializer;
import Serializer.StudentSerializer;
import Serializer.SuggestionsSerializer;

public class SaveHandler {
    public static void saveData(){
        StudentManager studentManager=new StudentManager();
        StaffManager staffManager=new StaffManager();
        CampDatabase campDatabase=new CampDatabase();
        EnquiriesManager enquiriesManager=new EnquiriesManager();
        SuggestionsManager suggestionsManager=new SuggestionsManager();
        CampManager campManager=new CampManager();

        StaffSerializer.saveStaffs(staffManager.getStaff(), "StaffDatabase.ser");
        StudentSerializer.saveStudents(studentManager.getStudents(),"StudentDatabase.ser");
        CampSerializer.saveCamps(CampDatabase.getCamps(),"CampsDatabase.ser");
        EnquiriesSerializer.saveEnquiries(EnquiriesManager.getEnquiry(), "EnquriesDatabase.ser");
        SuggestionsSerializer.saveSuggestions(SuggestionsManager.getSuggestions(), "SuggestionsDatabase.ser");
        

    }
}
