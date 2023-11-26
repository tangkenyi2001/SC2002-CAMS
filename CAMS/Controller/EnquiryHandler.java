package Controller;
import java.util.*;
import Entity.Camp;
import Entity.CampDatabase;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;
import Manager.EnquiriesManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Serializer.EnquiriesSerializer;
import Serializer.SuggestionsSerializer;

/**
 * The EnquiryHandler class provides methods to handle student enquiries.
 * Students can edit, submit, and delete enquiries.
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */
public class EnquiryHandler {

	/**
	 * Edits the selected enquiry for the specific student.
	 *
	 * @param student The student who wants to edit an enquiry he/she made.
	 */
	public static void editEnquiry(Student student){
		Scanner sc = new Scanner(System.in);
		int choice;
		ViewHandler.viewEnquiries(student);
		System.out.println("Select enquiry to edit:");
		System.out.println("Press <0> to cancel");
		choice = sc.nextInt()-1;
		if (choice == -1) return;
		Enquiry enquiryToEdit = student.getEnquiries().get((choice));
		if (enquiryToEdit.getProcessed())
		{
			System.out.println("Enquiry has been processed, unable to edit.");
			return;
		}
		else{
			student.getEnquiries().remove(enquiryToEdit);
			System.out.println("Enter edited enquiry:");
			sc.nextLine();
			String newContent = sc.nextLine();
			enquiryToEdit.setContent(newContent);
			student.getEnquiries().add(choice, enquiryToEdit);
			EnquiriesManager.update(enquiryToEdit);
			StudentManager.updateStudents(student);
			Updater.updateAll(enquiryToEdit.getCamp().getIC(), student, enquiryToEdit, null, enquiryToEdit.getCamp());
		}
	}


	/**
	 * Submits a new enquiry for the specific student.
	 *
	 * @param student The student submitting the enquiry.
	 */
	public static void submitEnquiry(Student student) {
		ArrayList<Camp> enquiryCamps = ViewHandler.viewEnquiryAvailable(student);
		if (enquiryCamps.isEmpty()){
			System.out.println("There are no available camps right now!");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Select camp to submit enquiry for: ");
		int choice = sc.nextInt()-1;
		Camp camp = enquiryCamps.get(choice);
		if (student.getCampCommittee()!=null)
		{
			if (student.getCampCommittee().getCommitteeOf().equals(camp))
			{
				System.out.println("Cannot submit enquiry for camps that you are committee of ! ");
				return;
			}
		}

		System.out.println("Enter Enquiry: ");
		sc.nextLine();
		String content = sc.nextLine();
		Enquiry enquiry = new Enquiry(student, content, camp);
		camp.addEnquiry(enquiry);
		student.getEnquiries().add(enquiry);
		System.out.println("Enquiry submitted for camp " + camp.getCampInfo().getCampName() + ".");
		CampDatabase.updateCamp(camp);
		EnquiriesManager.update(enquiry);
		StudentManager.updateStudents(student);
		StaffManager.updateStaff(camp.getIC());
		for (int j = 0; j<camp.getCommittee().size(); j++){
			StudentManager.updateStudents(camp.getCommittee().get(j));
		}
		
	}
	/**
	 * Deletes the selected enquiry for the specific student.
	 *
	 * @param student The student who wants to delete an enquiry he/she made.
	 */
	public static void deleteEnquiry(Student student){
		ViewHandler.viewEnquiries(student);
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Select enquiry to delete: ");
		choice = sc.nextInt();
		Enquiry enquiryToDelete = student.getEnquiries().get((choice -1));
		ArrayList<Camp> campList = new ArrayList<>(CampDatabase.getCamp());
		Camp myCamp = enquiryToDelete.getCamp();
		int i = 0;
		if (enquiryToDelete.getProcessed())
		{
			System.out.println("Enquiry has been processed, unable to delete.");
			return;
		}
		//See .filter if loop too clunky
		else{
			Camp camp;
			camp = campList.get(i);
			for (i = 0; i < campList.size(); i++) {
				camp = campList.get(i);
				if (camp.getCampInfo().getCampName().equals(myCamp.getCampInfo().getCampName())){
					camp.getEnquiries().remove(enquiryToDelete);
					student.getEnquiries().remove(enquiryToDelete);
					int index=camp.getIC().getCreatedCamps().indexOf(camp);
					camp.getIC().getCreatedCamps().set(index,camp);

					break;
				}
			}

			CampDatabase.updateCamp(camp);
			EnquiriesSerializer.saveEnquiries(camp.getEnquiries(), "EnquiriesDatabase.ser");
			StudentManager.updateStudents(student);
			StaffManager.updateStaff(camp.getIC());
			Updater.updateAll(camp.getIC(),student,enquiryToDelete,null,camp);
		}
	}
}



	
		