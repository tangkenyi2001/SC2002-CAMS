package Boundary;
/**
 * UI Menu for when staff clicks on view created camps
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
 */
import java.io.IOException;
import java.util.Scanner;
import Controller.GenerateHandler;
import Controller.IndexHelper;
import Controller.StaffEnquiryHandler;
import Controller.StaffSuggestionsHandler;
import Controller.StaffViewHandler;
import Entity.Staff;

public class StaffCreated {
/**
 * Method that prints out the menu
 * @param aStaff
 */
    public static void printMenu(Staff aStaff) throws IOException{
        Scanner sc = new Scanner(System.in);
        int choice, campNo;
        do{
            StaffViewHandler.viewCreated(aStaff);
            if (aStaff.getCreatedCamps().isEmpty()) return;
            System.out.println("    <1> View camp information");
            System.out.println("    <2> View camp suggestions");
            System.out.println("    <3> View camp enquiries");
            System.out.println("    <4> Generate report");
            System.out.println("    <5> View Attendees");
            System.out.println("    <6> View Camp Committee");
            System.out.println("    <7> Back");
            System.out.println("    Enter choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1: 
                    StaffViewHandler.viewCampInfo(aStaff);
                    break;
                case 2:
                    campNo = IndexHelper.indexOfCamp();
                    StaffSuggestionsHandler.view(aStaff, campNo);
                    break;
           
                case 3:
                    campNo = IndexHelper.indexOfCamp();
                    StaffEnquiryHandler.view(aStaff, campNo);
                    break;
                case 4: 
                    campNo = IndexHelper.indexOfCamp();
                    GenerateHandler.generateReport(aStaff.getCreatedCamps().get(campNo));
                    break;
                case 5:
                    campNo = IndexHelper.indexOfCamp();
                    StaffViewHandler.viewAttendees(aStaff,aStaff.getCreatedCamps().get(campNo));
                    break;
                case 6:
                    campNo = IndexHelper.indexOfCamp();
                    StaffViewHandler.viewCommittee(aStaff,aStaff.getCreatedCamps().get(campNo));
                    break;


            }
            //if (choice !=7) Beauty.backFunction();
        } while(choice <5 && choice >0);
    }
}


