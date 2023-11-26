package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.Camp;
import Entity.CampDatabase;
import Entity.Staff;
/**
 * Takes care of all actions pertaining viewing of all camp information for staffs
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class StaffViewHandler {
    /**
     * Prints all created camps
     */
    public static void view() {
		int i=0;
		ArrayList<Camp> camps;
		camps = CampDatabase.getCamp(); 
		if (camps.isEmpty()) {
            System.out.println("There are currently no camps created.");
        } else {
            System.out.println("List of all camps:");
            for (Camp camp : camps) {
				i +=1;
                System.out.println("(" + i + ")" + " Camp Name: " + camp.getCampInfo().getCampName());
			}
            viewCampInfo(camps);
		}

	}
    /**
     * Prints all camps that staff has created
     * @param aStaff Staff user
     */
    public static void viewCreated(Staff aStaff){
        int i = 0;
		ArrayList<Camp> createdCamps = aStaff.getCreatedCamps();
		if (createdCamps.isEmpty()) {
            System.out.println("You have not created any camps yet.");
        } else {
            System.out.println("List of Created Camps:");
            for (Camp camp : createdCamps) {
				i +=1;
                System.out.println("("+i+")" + " Camp Name: " + camp.getCampInfo().getCampName());
			}
		}
    }
    /**
     * Prints camp information of camp that user will be able to select from their created camps
     * @param aStaff Staff user
     */
    public static void viewCampInfo(Staff aStaff){
        int choice = IndexHelper.indexOfCamp();
        if(choice !=-1){
            Camp camp = aStaff.getCreatedCamps().get(choice);
            camp.printInfo();
        }
    }
    /**
     * Prints all camp information of camps in array list of camps passed in
     * @param camps Array list of camps
     */
    public static void viewCampInfo(ArrayList<Camp> camps){
        int choice = IndexHelper.indexOfCamp();
        if(choice != -1){
            Camp camp = camps.get(choice);
            camp.printInfo();
        }
    }
    /**
     * Prints list of attendees that is attending camp passed into the method
     * @param aStaff Staff user
     * @param camp Camp that user wishes to view attendees of 
     */
    public static void viewAttendees(Staff aStaff, Camp camp){
        if (camp.getAttendees().isEmpty()){ System.out.println("There are no Attendees!"); return;}
        System.out.println("Camp: " + camp.getCampInfo().getCampName()); // Print camp name
            System.out.println("Attendees ");
            for (int i=0;i<camp.getAttendees().size();i++){
                System.out.print("("+(i+1)+")");
                System.out.println(camp.getAttendees().get(i).getName());
            }
    }
    /**
     * Prints list of camp commmittee members that is attending camp passed into the method
     * @param aStaff Staff user
     * @param camp Camp that user wishes to view camp commmittee members of 
     */
    public static void viewCommittee(Staff aStaff, Camp camp){
         if (camp.getCommittee().isEmpty()){ System.out.println("There are no Committee Members!"); return;}
        System.out.println("Camp: " + camp.getCampInfo().getCampName()); // Print camp name
        System.out.println("Camp Committee ");
        for (int i=0;i<camp.getCommittee().size();i++){
            System.out.print("("+(i+1)+")");
            System.out.println(camp.getCommittee().get(i).getName() + " Points:"+camp.getCommittee().get(i).getPoints());
        }
    }
}
