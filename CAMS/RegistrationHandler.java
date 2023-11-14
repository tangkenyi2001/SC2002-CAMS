import java.util.*;
public class RegistrationHandler {

	public static void registerCamp(Student student, Camp camp){
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("(1) As attendee");
		System.out.println("(2) As committee member");
		System.out.println("Enter choice: ");
		choice = sc.nextInt();
		if(choice == 1){
			if(!camp.getBlackList().contains(student)){
				camp.getAttendees().add(student);
				camp.getCampInfo().minusSlot();
				student.getRegisteredCamps().add(camp);
			}else{
				System.out.println("Already registered for camp previously.");
			}
		}
		else if(choice == 2){
			if(student.getCampCommittee() == null && !camp.getBlackList().contains(student)){
				camp.getCampInfo().minusCommitteeSlots();
				camp.getCampInfo().minusSlot();
				CampCommittee committee = new CampCommittee(camp);
				student.setCampCommitee(committee);
				camp.addCommittee(student);
				//Should we add?
				//student.getRegisteredCamps().add(camp);
			}
			else if(student.getCampCommittee() != null && !camp.getBlackList().contains(student)){
				System.out.println("Already a camp commitee member.");
			}
			else if(camp.getBlackList().contains(student)){
				System.out.println("Already registered for camp previously.");
			}
		}
	}

	public static void withdrawCamp(Student student){
		Scanner sc = new Scanner(System.in);
		student.viewRegistered();
		System.out.println("Select camp to withdraw from: ");
		int choice = sc.nextInt();
		Camp camp = student.getRegisteredCamps().get(choice - 1);
		student.getRegisteredCamps().remove(choice - 1);
		int index = camp.getAttendees().indexOf(student);
		camp.getAttendees().remove(index);
		camp.addBlackList(student);
		System.out.println(student.getName() + " has withdrawn from " + camp.getCampInfo().getCampName() + ".");
	}
}
