import java.util.ArrayList;

public class Camp {

	private CampInfo campInformation;
	private ArrayList<Student> attendees;
	private ArrayList<Student> campCommittees;
	private boolean visibility = false;
	private ArrayList<Enquiry> campEnquiries;
	private ArrayList<Suggestions> campSuggestions;
	private ArrayList<Student> blackList;
	private Staff IC; 
	public Camp(Staff aStaff) {
		this.campInformation = new CampInfo(aStaff);
        this.attendees = new ArrayList<>();
        this.campCommittees = new ArrayList<>();
        this.visibility = false; // Default visibility is false
        this.campEnquiries = new ArrayList<>();
        this.campSuggestions = new ArrayList<>();
		this.blackList = new ArrayList<>();
		this.IC = aStaff;
	}
<<<<<<< Updated upstream:CAMS/Camp.java

=======
	public void printInfo(){
		System.out.println("Camp Name: "+getCampInfo().getCampName());
		System.out.println("Start Date: "+getCampInfo().getStartDate());
		System.out.println("End Date: "+getCampInfo().getEndDate());
		System.out.println("Registration Deadline: "+getCampInfo().getDeadline());
		System.out.println("User Group: "+getCampInfo().getUserGroup());
		System.out.println("Location: "+getCampInfo().getLocation());
		System.out.println("Total Slots: "+getCampInfo().getTotalSlots());
		System.out.println("Number of Committee Slots: "+getCampInfo().getCommitteeSlots());
		System.out.println("Camp Description: "+getCampInfo().getDescription());
		System.out.println("Staff-In_Charge: "+getCampInfo().getStaffIC().getName());
		System.out.println("Camp Visbility: "+getVisibility());
	}
>>>>>>> Stashed changes:CAMS/Entity/Camp.java
	public CampInfo getCampInfo(){
		return campInformation;
	}
	public ArrayList<Student> getAttendees() {
		return this.attendees;
	}

	public Staff getIC(){
		return this.IC; 
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

	public ArrayList<Enquiry> getEnquiries() {
        return this.campEnquiries;
    }

	public ArrayList<Suggestions> getSuggestions() {
        return this.campSuggestions;
    }

	public void addEnquiry(Enquiry anEnquiry) {
        this.campEnquiries.add(anEnquiry);
    }

	public void addSuggestion(Suggestions aSuggestion) {
        this.campSuggestions.add(aSuggestion);
    }

	public void printAttendees() {
        System.out.println("Attendees: ");
        for (Student attendee : attendees) {
            System.out.println(attendee.getName());
        }
    }
	public void printCommitteeMembers() {
        System.out.println("Committee Members: ");
        for (Student committeeMember : campCommittees) {
            System.out.println(committeeMember.getName());
        }
    }
	public void addBlackList(Student student) {
		this.blackList.add(student);
	}
	public ArrayList<Student> getBlackList() {
		return this.blackList;
	}
}