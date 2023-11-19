import java.util.Scanner;

import Boundary.StaffMenu;
import Boundary.StudentMenu;
import Controller.Beauty;
import Controller.LoginHandler;
import Entity.CampDatabase;
import Entity.Staff;
import Entity.Student;
import Manager.CsvReader;

public class main {

    public static void main(String arg[]) {
        //CampDatabase camper=new CampDatabase();
        //camper.addCamps();
        //Camp Camp0=camper.getCamps().get(0);
        //System.out.println(Camp0.getCampInfo().getCampName()); */
        CampDatabase a = new CampDatabase();
        //LoginHandler.login();//will print the menu accordingly.
        //CsvReader.readstaff();
       // CsvReader.readstudent();
       // LoginHandler.login();
        Staff aStaff = new Staff("thor" , "thor", "thor", "thor");
        StaffMenu.printMenu(aStaff, CampDatabase.getCamps());
       // Student john = new Student("123", "john", "john", "SCSE");
        //StudentMenu.printMenu(john, CampDatabase.getCamps());

    }

}
