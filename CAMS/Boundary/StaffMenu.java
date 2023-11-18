package Boundary;
import java.util.*;

import Controller.Beauty;
import Controller.CampModifier;
import Controller.PasswordHandler;
import Controller.ViewHandler;
import Entity.Camp;
import Entity.Staff;
public class StaffMenu {
    public static void printMenu(Staff aStaff, ArrayList<Camp> campList){
        Scanner sc = new Scanner(System.in);
        int choice;
        int i;
        do{
            Beauty.mainMenu();
            System.out.println("(1) Create Camp");
            System.out.println("(2) View All Camps");
            System.out.println("(3) View Created Camps");
            System.out.println("(4) Edit Camp");
            System.out.println("(5) Delete Camp");
            System.out.println("(6) Change password");
            System.out.println("(7) Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    CampModifier.createCamp(aStaff);
                    break;

                case 2:
                    ViewHandler.viewAll();
                    break;

                case 3:
                    StaffCreated.printMenu(aStaff);                    
                    break;
                    
                case 4:
                    CampModifier.editCamp(aStaff);
                    break;

                case 5:
                    CampModifier.deleteCamp(aStaff);
                    break;
                case 6: PasswordHandler.changePassword(aStaff);
                        break;
            } if (choice != 7) Beauty.backFunction();
        } while(choice < 7 && choice>0);
    }
}