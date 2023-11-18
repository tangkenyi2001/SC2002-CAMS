package Controller;
import java.util.*;
import Entity.Camp;
import Entity.CampDatabase;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;


public class EnquiryHandler {

	static Scanner sc = new Scanner(System.in);

	public static void editEnquiry(Enquiry enquiry, Student student){
		if(!enquiry.getProcessed()){
			System.out.println("Enter edited enquiry: ");
			String newContent = sc.next();
			enquiry.setContent(newContent);
		}else{
			System.out.println("Enquiry has been processed, unable to edit.");
		}
	}


	
	public static void submitEnquiry(Student student, String content, Camp camp) {
		Enquiry enquiry = new Enquiry(student.getName(), content, camp);
		camp.addEnquiry(enquiry);
		student.getEnquiries().add(enquiry);
	}



	public static void deleteEnquiry(Enquiry enquiry, Student student){
		ArrayList<Camp> campList = new ArrayList<>(CampDatabase.getCamps());
		String name = enquiry.getCamp();
		int i = 0;
		//See .filter if loop too clunky
		if(!enquiry.getProcessed()){
			Camp camp;
			camp = campList.get(i);
			for (i = 0; i < campList.size(); i++) {
				camp = campList.get(i);
				if (camp.getCampInfo().getCampName().equals(name)){
					camp.getEnquiries().remove(enquiry);
					student.getEnquiries().remove(enquiry);
					break;
				}
			}
			camp.getEnquiries().remove(enquiry);	
			student.getEnquiries().remove(enquiry);
		}else{
			System.out.println("Enquiry has been processed, unable to delete.");
		}
	}


	

}



	
		