package Boundary;
import java.util.*;

import Controller.Beauty;
import Controller.CampEditor;
import Controller.CampModifier;
import Controller.LogoutHandler;
import Controller.PasswordHandler;
import Controller.StaffViewHandler;
import Entity.Camp;
import Entity.Staff;
public class StaffMenu {

    public static void printMenu(Staff aStaff, ArrayList<Camp> arrayList){
        Scanner sc = new Scanner(System.in);
        int choice;
        int i;
        do{
            Beauty.mainMenu();
            System.out.println("(1) View All Camps");
            System.out.println("(2) View Created Camps");
            System.out.println("(3) Create a camp");
            System.out.println("(4) Delete a Camp");
            System.out.println("(5) Edit camps");
            System.out.println("(6) Change password");
            System.out.println("(7) Logout");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    StaffViewHandler.view();
                    break;

                case 2:
                    StaffCreated.printMenu(aStaff);  
                    break;

                case 3:
                    CampModifier.createCamp(aStaff);                  
                    break;
                    
                case 4:
                    CampModifier.deleteCamp(aStaff);
                    break;

                case 5:
                    CampEditor.editCamp(aStaff);
                    break;

                case 6: 
                    PasswordHandler.changePassword(aStaff);
                    break;
                case 7:
                    //save
                    LogoutHandler.logout();
            } if (choice != 7 && choice !=5) Beauty.backFunction();
        } while(choice < 8 && choice>0);
    }
}