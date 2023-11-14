import java.util.Scanner;

public class CampModifier {

	public static void createCamp(Staff aStaff) {
		Camp aCamp = new Camp();
		CampDatabase.addCamps(aCamp);
		aStaff.addToCreatedCamps(aCamp);
		System.out.println("Camp successfully created!\nReturning to main menu");
	}

	public static void editCamp(Staff aStaff, int i) {
		Scanner sc = new Scanner(System.in);
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
        }while(choice<7 && choice>0);
	}

	public static void deleteCamp(Staff aStaff, int i) {
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