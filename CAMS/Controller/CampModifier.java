package Controller;
import java.util.Scanner;
import Entity.Camp;
import Entity.CampDatabase;
import Entity.Staff;
import Manager.StaffManager;

public class CampModifier {
	static Scanner sc = new Scanner(System.in);

	public static void createCamp(Staff aStaff) {
		Camp aCamp = new Camp();
		CampDatabase.addCamps(aCamp);
		aStaff.addToCreatedCamps(aCamp);
		StaffManager staffManager=new StaffManager();
		staffManager.updateStaff(aStaff);
	}


	public static void deleteCamp(Staff aStaff) {
        StaffViewHandler.viewCreated(aStaff);
		if (aStaff.getCreatedCamps().isEmpty()) return;
		System.out.println("Which camp would you like to delete?");
        int i = sc.nextInt()-1;
		Camp theCamp = aStaff.getCreatedCamps().get(i);
		if( theCamp.getAttendees().isEmpty() && theCamp.getCommittee().isEmpty() ){   
			CampDatabase.getCamps().remove(theCamp);
			aStaff.getCreatedCamps().remove(theCamp);
			System.out.println("Camp successfuly deleted");
		}
		else {
			System.out.println("Error : There are attendees or Camp Committee members registered!");
		}		
	}

	

}