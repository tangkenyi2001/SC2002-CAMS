public class EnquiryHandler {

	public void reply() {
		// TODO - implement EnquiryHandler.reply
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param staff
	 */
	public void view(Staff staff) {
		// TODO - implement EnquiryHandler.view
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param student
	 */
	public static void view(Student student) {
		for(int i = 0; i < student.getEnquiries().size(); i++){
			System.out.println((i+1) + " " + student.getEnquiries().get(i).getContent());
		}
	}

	/**
	 * 
	 * @param cc
	 */
	public void view(CampCommittee cc) {
		// TODO - implement EnquiryHandler.view
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 */
	public static void submitEnquiry(Student student, String content, Camp camp) {
		Enquiry enquiry = new Enquiry(student.getname(), content, camp);
		camp.addEnquiry(enquiry);
		student.getEnquiries().add(enquiry);
	}

	public static void deleteEnquiry(Enquiry enquiry) {
		
	}

}