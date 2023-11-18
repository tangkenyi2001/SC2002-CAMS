package Boundary;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.Beauty;
import Controller.EnquiryHandler;
import Controller.SuggestionHandler;
import Entity.Camp;
import Entity.Staff;
import Manager.EnquiriesManager;

public class StaffCreated {
    public static void printMenu(Staff aStaff){
        Scanner sc = new Scanner(System.in);
        int choice, campNo;
        do{
            aStaff.viewCreatedCamps();
            if (aStaff.getCreatedCamps().isEmpty()) return;
            System.out.println("    <1> View camp suggestions");
            System.out.println("    <2> View camp enquiries");
            System.out.println("    <3> Back");
            System.out.println("    Enter choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    campNo = indexOfCamp();
                    SuggestionHandler.viewSuggestions(aStaff, campNo);
                    break;
           
                case 2:
                    campNo = indexOfCamp();
                    EnquiryHandler.viewEnquiries(aStaff, campNo);
                    break;
            }
            if (choice !=3) Beauty.returnMenu();
        } while(choice <3 && choice >0);
    }

    private static int indexOfCamp() {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the camp you would like to view:");
        choice = sc.nextInt();
        return choice-1;
    }
}


