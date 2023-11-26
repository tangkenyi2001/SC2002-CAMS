package Controller;

import java.util.concurrent.Flow.Subscription;

import Entity.Camp;
import Entity.CampDatabase;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;
import Entity.Suggestions;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;
/**
 * Updates databases
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class Updater {
    /**
     * Updates all parameters in their respective databases
     * @param staff Staff to update
     * @param student Student to update 
     * @param enquiry Enquiry to update
     * @param suggestion Suggestion to update
     * @param camp Camp to update
     */
    public static void updateAll(Staff staff, Student student, Enquiry enquiry, Suggestions suggestion, Camp camp ){
        if (staff != null){
            StaffManager.updateStaff(staff);
        }

         if (student != null){
            StudentManager.updateStudents(student);
        }

         if (enquiry != null){
            EnquiriesManager.update(enquiry);
        }
        
         if (suggestion != null){
            SuggestionsManager.update(suggestion);
        }

         if (camp != null){
            CampDatabase.updateCamp(camp);
        }
    }
}
