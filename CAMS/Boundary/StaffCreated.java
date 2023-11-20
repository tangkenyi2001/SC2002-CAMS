package Boundary;
import java.io.IOException;
import java.util.Scanner;
import Controller.Beauty;
import Controller.GenerateHandler;
import Controller.IndexHelper;
import Controller.StaffEnquiryHandler;
import Controller.StaffSuggestionsHandler;
import Controller.StaffViewHandler;
import Controller.SuggestionHandler;
import Entity.Staff;

public class StaffCreated {

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
            System.out.println("    <5> Back");
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
            }
            if (choice !=5) Beauty.backFunction();
        } while(choice <5 && choice >0);
    }
}


