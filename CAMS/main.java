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
import Manager.CampManager;
import Manager.CsvReader;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;

public class main {

    public static void main(String arg[]) throws IOException {
        //CampDatabase a = new CampDatabase();
        //LoginHandler.login();
        StudentManager studentManager=new StudentManager();
        StaffManager staffManager=new StaffManager();
        CampDatabase campDatabase=new CampDatabase();
        EnquiriesManager enquiriesManager=new EnquiriesManager();
        SuggestionsManager suggestionsManager=new SuggestionsManager();
        CampManager campManager=new CampManager();
        mainMenu.printMainMenu();
        //Staff aStaff = new Staff("thor" , "thor", "thor", "thor");
        //StaffMenu.printMenu(aStaff, CampDatabase.getCamps());
       // Student john = new Student("123", "john", "john", "SCSE");
        //StudentMenu.printMenu(john, CampDatabase.getCamps());
        
    }

}
