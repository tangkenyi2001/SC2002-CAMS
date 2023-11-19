import java.util.Scanner;

import Boundary.StaffMenu;
import Boundary.StudentMenu;
import Boundary.mainMenu;
import Controller.Beauty;
import Controller.IntialiseHandler;
import Controller.LoginHandler;
import Entity.CampDatabase;
import Entity.Staff;
import Entity.Student;
import Manager.CsvReader;

public class main {

    public static void main(String arg[]) {
        CampDatabase a = new CampDatabase();
        mainMenu.printMainMenu();
        //Staff aStaff = new Staff("thor" , "thor", "thor", "thor");
        //StaffMenu.printMenu(aStaff, CampDatabase.getCamps());
       // Student john = new Student("123", "john", "john", "SCSE");
        //StudentMenu.printMenu(john, CampDatabase.getCamps());

    }

}
