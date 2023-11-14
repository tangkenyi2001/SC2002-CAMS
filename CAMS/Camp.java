import java.util.ArrayList;

public class Camp {

	private CampInfo campInformation;
	private ArrayList<Student> attendees;
	private ArrayList<Student> campCommittees;
	private boolean visibility = false;

	private ArrayList<Enquiries> campEnquiries;

	private ArrayList<Suggestions> campSuggestions;

	public Camp() {
		this.campInformation = new CampInfo();
        this.attendees = new ArrayList<>();
        this.campCommittees = new ArrayList<>();
        this.visibility = false; // Default visibility is false
        this.campEnquiries = new ArrayList<>();
        this.campSuggestions = new ArrayList<>();
	}

	public CampInfo getCampInfo(){
		return campInformation;
	}
	public ArrayList<Student> getAttendees() {
		return this.attendees;
	}

	
	public void addAttendees(Student name) {
		this.attendees.add(name);
	}


	public ArrayList<Student> getCommittee() {
		return this.campCommittees;
	}

	
	public void addCommittee(Student name) {
		this.campCommittees.add(name);
	}

	public boolean getVisibility() {
		return this.visibility;
	}

	public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

	public ArrayList<Enquiries> getEnquiries() {

        return this.campEnquiries;
    }

	public ArrayList<Suggestions> getSuggestions() {
        return this.campSuggestions;
    }


	public void addEnquiry(Enquiries anEnquiry) {

        this.campEnquiries.add(anEnquiry);
    }

	public void addSuggestion(Suggestions aSuggestion) {
        this.campSuggestions.add(aSuggestion);
    }

	public void printAttendees() {
        System.out.println("Attendees: ");
        for (Student attendee : attendees) {
            System.out.println(attendee.getname());
        }
    }
	public void printCommitteeMembers() {
        System.out.println("Committee Members: ");
        for (Student committeeMember : campCommittees) {
            System.out.println(committeeMember.getname());
        }
    }
}