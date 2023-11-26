package Controller;
import java.util.Scanner;

import Entity.Camp;
import Entity.Staff;
import Manager.StaffManager;
import Serializer.CampSerializer;
import Entity.CampDatabase;
/**
 * The CampEditor class provides methods for editing camp information.
 * It allows a staff member to edit information such as dates, deadline, description, slots, visibility, and user group.
 * A staff can only edit a camp he/she is in charge of
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */
public class CampEditor {
    static Scanner sc = new Scanner(System.in);
    /**
     * Allows the staff to choose a camp that he created and edit it.
     *
     * @param aStaff The staff member initiating the camp editing.
     */
    public static void editCamp(Staff aStaff) {
		StaffViewHandler.viewCreated(aStaff);
		if(aStaff.getCreatedCamps().isEmpty()){ Beauty.backFunction();
        return;}
		System.out.println("Which camp would you like to edit?");
		int i = sc.nextInt()-1;		
		Camp theCamp = aStaff.getCreatedCamps().get(i);
		int choice;
		
		do{
            System.out.println("What would you like to edit?");
			System.out.println("(1) Start and End date");
            System.out.println("(2) Registration deadline");
            System.out.println("(3) Description");
            System.out.println("(4) Total number of Slots");  //split into attendees or CC
            System.out.println("(5) Visibility");
			System.out.println("(6) User Group");
			System.out.println("(7) Back");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
					CampEditor.editDates(theCamp);
                    break;
                case 2:
                    CampEditor.editDeadline(theCamp);
                    break;
                case 3:
                    CampEditor.editDescription(theCamp);
                    break;
                case 4:
					CampEditor.editSlots(theCamp);
                    break;
                case 5:
                    CampEditor.editVisibility(theCamp);
                    break;
                case 6:
                    CampEditor.editUserGroup(theCamp);
                    break;
            }
            Updater.updateAll(aStaff, null, null, null, theCamp);
            Beauty.backFunction();
        }while(choice<7 && choice>0);
	}
    /**
     * Edits the start and end dates of the camp.
     *
     * @param aCamp The camp that the staff wants to edit.
     */
    public static void editDates(Camp aCamp){
        aCamp.getCampInfo().setStartDate();
        aCamp.getCampInfo().setEndDate();
        System.out.println("Dates successfully changed!");
    }
    /**
     * Edits the registration deadline of the camp.
     *
     * @param aCamp The camp that the staff wants to edit.
     */
    public static void editDeadline(Camp aCamp){
        aCamp.getCampInfo().setDeadline();
        System.out.println("Deadline successfully changed!");
    }
    /**
     * Edits the description of the camp.
     *
     * @param aCamp The camp that the staff wants to edit.
     */
    public static void editDescription(Camp aCamp){
        aCamp.getCampInfo().setDescription();
        System.out.println("Description successfully changed!");
    }
    /**
     * Edits the total number of slots and committee slots of the camp.
     *
     * @param aCamp The camp that the staff wants to edit.
     */
    public static void editSlots(Camp aCamp){
        aCamp.getCampInfo().setTotalSlots();
        aCamp.getCampInfo().setCommitteeSlots();
        System.out.println("Slots successfully changed!");
    }
    /**
     * Toggles the visibility of the camp only if there are no attendees or committee members.
     *
     * @param aCamp The camp that the staff wants to edit.
     */
    public static void editVisibility(Camp aCamp) {
        // if no attendee/committe, then can toggle
        if( aCamp.getAttendees().isEmpty() && aCamp.getCommittee().isEmpty() ){             //i
            if(aCamp.getVisibility()){
                aCamp.setVisibility(false);
                System.out.println("Visibility toggled to false!");
            }
            else
            {
                aCamp.setVisibility(true);
                System.out.println("Visibility toggled to true!");
            }

        }

        else {
            System.out.println("Error : There are attendees or Camp committe members registered!");
        }
    }
    /**
     * Edits the user group of the camp.
     *
     * @param aCamp The camp that the staff wants to edit.
     */
    public static void editUserGroup(Camp aCamp) {
        aCamp.getCampInfo().setUserGroup();
        System.out.println("UserGroup successfully changed!");
    }


}
