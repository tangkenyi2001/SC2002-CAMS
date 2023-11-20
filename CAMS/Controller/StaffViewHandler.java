package Controller;

import java.util.ArrayList;
import Entity.Camp;
import Entity.CampDatabase;
import Entity.Staff;

public class StaffViewHandler {

    public static void view() {
		int i=0;
		ArrayList<Camp> camps;
		camps = CampDatabase.getCamps(); 
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

    public static void viewCampInfo(Staff aStaff){
        int choice = IndexHelper.indexOfCamp();
        if(choice !=-1){
            Camp camp = aStaff.getCreatedCamps().get(choice);
            camp.printInfo();
        }
    }

    public static void viewCampInfo(ArrayList<Camp> camps){
        int choice = IndexHelper.indexOfCamp();
        if(choice !=-1){
            Camp camp = camps.get(choice);
            camp.printInfo();
        }
    }

}
