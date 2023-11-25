import java.util.*;
<<<<<<< Updated upstream:CAMS/RegistrationHandler.java
=======
import Entity.Camp;
import Entity.CampCommittee;
import Entity.CampDatabase;
import Entity.Student;
import Manager.StudentManager;
>>>>>>> Stashed changes:CAMS/Controller/RegistrationHandler.java
public class RegistrationHandler {

	public static void registerCamp(Student student){
		Scanner sc = new Scanner(System.in);
		int choice;
		Camp camp;
		ArrayList<Camp> availableCamps = ViewHandler.viewRegisterAvailable(student);
		if (availableCamps.size()==0){
			System.out.println("No available Camps");
		}
		else{
			System.out.println("Select camp to register for: ");
			choice = sc.nextInt();
			camp = availableCamps.get(choice -1);  // camp he is registering for 
			System.out.println("(1) As attendee");
			System.out.println("(2) As committee member");
			System.out.println("Enter choice: ");
			choice = sc.nextInt();
			if(choice == 1){
				if(!camp.getBlackList().contains(student)){
					for (int i=0; i<student.getRegisteredCamps().size(); i++){		//check if overlap with any registered
						Camp current = student.getRegisteredCamps().get(i);
						if (checkOverlap(current,camp)){
							System.out.println("Unable to register. This camp overlaps with one of your registered camp!");
							return;
						}
					}
					camp.getAttendees().add(student);
					if(camp.getCampInfo().getAttendeeSlots() > 0){
						student.getRegisteredCamps().add(camp);
						Updater.updateAll( camp.getIC() , student, null, null, camp);
						System.out.println("Registered for camp " + camp.getCampInfo().getCampName() + ".");
					}else{
						System.out.println("No more attendee slots for camp " + camp.getCampInfo().getCampName() + ".");
					}
				}else{
					System.out.println("Cannot register for a camp you have withdrawn from !");
				}
	
			}
			else if(choice == 2){
				if(student.getCampCommittee() == null && !camp.getBlackList().contains(student)){
					for (int i=0; i<student.getRegisteredCamps().size(); i++){		//check if overlap with any registered
						Camp current = student.getRegisteredCamps().get(i);
						if (checkOverlap(current,camp)){
							System.out.println("Unable to register. This camp overlaps with one of your registered camp!");
							return;
						}
					}
					if(camp.getCampInfo().getCommitteeSlots() > 0){
						camp.getCampInfo().minusCommitteeSlots();
						camp.getCampInfo().minusSlot();
						CampCommittee committee = new CampCommittee(camp);
						student.setCampCommittee(committee);
						camp.addCommittee(student);
						student.getRegisteredCamps().add(camp);
						System.out.println("Registered for camp " + camp.getCampInfo().getCampName() + " as committee member.");
						Updater.updateAll(camp.getIC(), student, null, null, camp);
					}else{
						System.out.println("No more committee slots for camp " + camp.getCampInfo().getCampName() + ".");
					}
				}
				else if(student.getCampCommittee() != null && !camp.getBlackList().contains(student)){
					System.out.println("Already a camp commitee member.");
				}
				else if(camp.getBlackList().contains(student)){
					System.out.println("Cannot register for a camp you have withdrawn from !");
				}
			}
			Updater.updateAll(camp.getIC(), student, null, null, camp);
		} 
	}

	public static boolean checkOverlap(Camp current, Camp camp){
		return (current.getCampInfo().getStartDate().isBefore(camp.getCampInfo().getEndDate()) && current.getCampInfo().getEndDate().isAfter(camp.getCampInfo().getStartDate()));
	}

	public static void withdrawCamp(Student student){
		Scanner sc = new Scanner(System.in);
		student.viewRegistered(student);
		System.out.println("Select camp to withdraw from: ");
		int choice = sc.nextInt();
		Camp camp = student.getRegisteredCamps().get(choice - 1);
		student.getRegisteredCamps().remove(choice - 1);
		int index = camp.getAttendees().indexOf(student);
		camp.getAttendees().remove(index);
		camp.addBlackList(student);
		System.out.println(student.getName() + " has withdrawn from " + camp.getCampInfo().getCampName() + ".");
		StudentManager.updateStudents(student);
		CampDatabase.updateCamp(camp);
		Updater.updateAll(camp.getIC(), student, null, null, camp);
		
	}
}
