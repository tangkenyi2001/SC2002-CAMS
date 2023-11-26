import java.io.IOException;
import java.util.Scanner;

import Boundary.StaffMenu;
import Boundary.StudentMenu;
import Boundary.mainMenu;
import Controller.Beauty;
import Controller.LoginHandler;
import Controller.SaveHandler;
import Entity.CampDatabase;
import Entity.Staff;
import Entity.Student;
import Entity.CampDatabase;
import Manager.CsvReader;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;

public class main {

    public static void main(String arg[]) throws IOException {
        StudentManager studentManager=new StudentManager();
        StaffManager staffManager=new StaffManager();
        CampDatabase campDatabase=new CampDatabase();
        EnquiriesManager enquiriesManager=new EnquiriesManager();
        SuggestionsManager suggestionsManager=new SuggestionsManager();
        mainMenu.printMainMenu();
      
    }

}
