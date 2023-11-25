<<<<<<< Updated upstream
public class main {

    public static void main(String arg[]) {
       /* CampDatabase camper=new CampDatabase();
        camper.addCamps();
        Camp Camp0=camper.getCamps().get(0);
        System.out.println(Camp0.getCampInfo().getCampName()); */
        CampDatabase a = new CampDatabase();
        Staff aStaff = new Staff("thor" , "thor", "thor", "thor");
        StaffMenu.printMenu(aStaff, CampDatabase.getCamps());
=======
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
>>>>>>> Stashed changes


    }
}
