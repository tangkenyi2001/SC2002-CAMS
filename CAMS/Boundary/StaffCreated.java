package Boundary;
import java.util.Scanner;
import Controller.Beauty;
import Controller.IndexHelper;
import Controller.StaffEnquiryHandler;
import Controller.StaffSuggestionsHandler;
import Controller.StaffViewHandler;
import Controller.SuggestionHandler;
import Entity.Staff;

public class StaffCreated {

    public static void printMenu(Staff aStaff){
        Scanner sc = new Scanner(System.in);
        int choice, campNo;
        do{
            StaffViewHandler.viewCreated(aStaff);
            if (aStaff.getCreatedCamps().isEmpty()) return;
            System.out.println("    <1> View camp suggestions");
            System.out.println("    <2> View camp enquiries");
            System.out.println("    <3> Back");
            System.out.println("    Enter choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    campNo = IndexHelper.indexOfCamp();
                    StaffSuggestionsHandler.view(aStaff, campNo);
                    break;
           
                case 2:
                    campNo = IndexHelper.indexOfCamp();
                    StaffEnquiryHandler.view(aStaff, campNo);
                    break;
            }
            if (choice !=3) Beauty.backFunction();
        } while(choice <3 && choice >0);
    }
}


