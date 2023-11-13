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
			camp.getAttendees().add(student);
			camp.getCampInfo().minusSlot();
			student.getRegisteredCamps().add(camp);
		}
		else if(choice == 2){
			if(student.getCampCommittee() != null){
				camp.getCampInfo().minusCommitteeSlots();
				camp.getCampInfo().minusSlot();
				CampCommittee committee = new CampCommittee(camp);
				student.setCampCommitee(committee);
				camp.addCommittee(student);
				student.getRegisteredCamps().add(camp);
			}
			else{
				System.out.println("Already a camp commitee member.");
			}
		}
	}

	public void withdrawCamp(Student student, Camp camp) {
		
	}

}