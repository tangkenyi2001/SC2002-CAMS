import java.util.*;
public class EnquiryHandler {

	public void replyEnquiry(Enquiry enquiry) {
		if(!enquiry.getProcessed()){
			System.out.println("Enter reply: ");
			String newReply = sc.next();
			enquiry.setReply(newReply);
		}else{
			System.out.println("Enquiry has been processed, unable to reply.");
		}
	}

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
		String name = enquiry.getCampName();
		int i = 0;
		//See .filter if loop too clunky
		if(!enquiry.getProcessed()){
			for (i = 0; i < list.size(); i++) {
				if (campList.get(i).getCampInfo().getCampName().equals(name)){
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