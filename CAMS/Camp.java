public class Camp {

	private CampInfo campInformation;
	private ArrayList<Student> attendees;
	private ArrayList<Student> campCommittees;
	private boolean visibility = 0;
	private ArrayList<Enquiries> campEnquiries;
	private ArrayList<Suggestions> campSuggestions;

	public Camp() {
		// TODO - implement Camp.Camp
		throw new UnsupportedOperationException();
	}

	public ArrayList<Students> getAttendees() {
		// TODO - implement Camp.getAttendees
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void addAttendees(Student name) {
		// TODO - implement Camp.addAttendees
		throw new UnsupportedOperationException();
	}

	public ArrayList<Students> getCommittee() {
		// TODO - implement Camp.getCommittee
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void addCommittee(Student name) {
		// TODO - implement Camp.addCommittee
		throw new UnsupportedOperationException();
	}

	public boolean getVisibility() {
		return this.visibility;
	}

	/**
	 * by default is 0 (students cannot see this camp)
	 * When this method is called, set visibility to 1 (Students can now see this camp)
	 */
	public void setVisibility() {
		// TODO - implement Camp.setVisibility
		throw new UnsupportedOperationException();
	}

	public ArrayList<Enquiry> getEnquiry() {
		// TODO - implement Camp.getEnquiry
		throw new UnsupportedOperationException();
	}

	public ArrayList<Suggestions> getSuggestions() {
		// TODO - implement Camp.getSuggestions
		throw new UnsupportedOperationException();
	}

	/**
	 * by default is 0 (students cannot see this camp)
	 * When this method is called, set visibility to 1 (Students can now see this camp)
	 * @param anEnquiry
	 */
	public void addEnquiry(Enquiries anEnquiry) {
		// TODO - implement Camp.addEnquiry
		throw new UnsupportedOperationException();
	}

	/**
	 * by default is 0 (students cannot see this camp)
	 * When this method is called, set visibility to 1 (Students can now see this camp)
	 * @param aSuggestion
	 */
	public void addSuggestion(Suggestions aSuggestion) {
		// TODO - implement Camp.addSuggestion
		throw new UnsupportedOperationException();
	}

	public void printAttendees() {
		// TODO - implement Camp.printAttendees
		throw new UnsupportedOperationException();
	}

	public void printCommitteeMembers() {
		// TODO - implement Camp.printCommitteeMembers
		throw new UnsupportedOperationException();
	}

}