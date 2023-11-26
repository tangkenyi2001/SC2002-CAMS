package Controller;
import java.util.Scanner;
import Entity.Camp;
import Entity.CampDatabase;
import Entity.Staff;
import Manager.StaffManager;
/**
 * The CampModifier class provides methods for creating and deleting camps.
 * It allows staffs to create new camps and delete an existing camp that has no participants.
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */

public class CampModifier {
	static Scanner sc = new Scanner(System.in);
	/**
	 * Creates a new camp by calling the camp constructor
	 * and setting the staff creating it as the CampInCharge.
	 *
	 * @param aStaff The staff member creating the camp.
	 */
	public static void createCamp(Staff aStaff) {
		Camp aCamp = new Camp(aStaff);
		CampDatabase.addNewCamp(aCamp);
		aStaff.addToCreatedCamps(aCamp);
		StaffManager staffManager=new StaffManager();
		staffManager.updateStaff(aStaff);
	}

	/**
	 * Deletes the camp created by the specified staff if there are no attendees or committee members.
	 *
	 * @param aStaff The staff member deleting the camp.
	 */
	public static void deleteCamp(Staff aStaff) {
        StaffViewHandler.viewCreated(aStaff);
		if (aStaff.getCreatedCamps().isEmpty()) return;
		System.out.println("Which camp would you like to delete?");
        int i = sc.nextInt()-1;
		Camp theCamp = aStaff.getCreatedCamps().get(i);
		if( theCamp.getAttendees().isEmpty() && theCamp.getCommittee().isEmpty() ){   
			CampDatabase.deleteCamps(theCamp);
			aStaff.getCreatedCamps().remove(theCamp);
			Updater.updateAll(aStaff, null, null, null, theCamp);
			//System.out.println("Camp successfuly deleted");
		}
		else {
			System.out.println("Error : There are attendees or Camp Committee members registered!");
		}		
	}

	

}