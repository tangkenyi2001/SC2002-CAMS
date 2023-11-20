package Controller;

import Manager.CsvReader;
import Manager.StaffManager;
import Manager.StudentManager;

public class IntialiseHandler {
    public static void loaddata() {
        StudentManager studentManager=new StudentManager();
        StaffManager staffManager=new StaffManager();
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
