package Controller;
import java.util.*;
import Entity.Camp;
import Entity.CampDatabase;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;


public class EnquiryHandler {

	public static void replyEnquiry(Enquiry enquiry) {
		Scanner sc = new Scanner(System.in);
		if(!enquiry.getProcessed()){
			System.out.println("Enter reply: ");
			String newReply = sc.next();
			enquiry.setReply(newReply);
		}else{
			System.out.println("Enquiry has been processed, unable to reply.");
		}
	}



	public static void editEnquiry(Enquiry enquiry, Student student){
		Scanner sc = new Scanner(System.in);
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



	public static void viewEnquiries(Staff aStaff, int index){
		Scanner sc = new Scanner(System.in);
		ArrayList<Camp> createdCamps = aStaff.getCreatedCamps();
		Camp aCamp = createdCamps.get(index);
		ArrayList<Enquiry> thisEnquiry = aCamp.getEnquiries();
		if(thisEnquiry.isEmpty())
            System.out.println("No enquiries yet.");
		else{
            System.out.println("List of enquiries:");
			for (int i=0; i<thisEnquiry.size(); i++) {
				Enquiry curr = thisEnquiry.get(i);
				System.out.println("("+(i+1)+") "+curr);
			}
		System.out.println("Which enquiry would you like to reply to?");
		int choice = sc.nextInt() - 1;
		replyEnquiry(thisEnquiry.get(choice));
		}	
	}

}



	
		