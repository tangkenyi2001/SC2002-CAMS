package Entity;
import java.util.ArrayList;
import java.io.Serializable;
/**
Represents a Camp.
Many camps can be created, and only can be created by a Staff. 
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
*/
public class Camp implements Serializable{
	/**
	 * Contains information about the camp.
	 */
	private CampInfo campInformation;
	/**
	 * Contains an arraylist of students that signed up as attendees for the camp.
	 */
	private ArrayList<Student> attendees;
	/**
	 * Contains an arraylist of students that signed up as a Camp Committee Mmeber for the camp.
	 */
	private ArrayList<Student> campCommittees;
	/**
	 * Visibility of the camp, 1 denotes visible to students, 0 denotes not visible.
	 */
	private boolean visibility = false;
	/**
	 * Contains an arraylist of enquiries that attendees submitted.
	 */
	private ArrayList<Enquiry> campEnquiries;
	/**
	 * Contains an arraylist of suggestions that Camp Committee members submitted.
	 */
	private ArrayList<Suggestions> campSuggestions;
	/**
	 * Contains an arraylist of Students(Attendees) that withdrew the camp.
	 * Those students will be unabe to register for this particular camp again.
	 */
	private ArrayList<Student> blackList;
	/**
	 * Contains the Staff object that is in charge of the camp.
	 */
	private Staff IC; 

	/**
	 * Constructor for camp.
	 * @param aStaff
	 */
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
	/**
	 * Prints camp information.
	 */
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

	/**
	 * Returns the camp information object of a camp.
	 * @return
	 */
	public CampInfo getCampInfo(){
		return campInformation;
	}

	/**
	 * Returns the array list of students that signed up as attendees.
	 * @return
	 */
	public ArrayList<Student> getAttendees() {
		return this.attendees;
	}

	/**
	 * Return the Staff in charge
	 * @return
	 */
	public Staff getIC(){
		return this.IC; 
	}

	/**
	 * Add the student object to the array list of attendees.
	 * @param name
	 */
	public void addAttendees(Student name) {
		this.attendees.add(name);
	}

	/**
	 * Return the array list of students that signed up as camp committee members.
	 * @return
	 */
	public ArrayList<Student> getCommittee() {
		return this.campCommittees;
	}

	/**
	 * Add the student to the array list of Camp Committee member.
	 * @param name
	 */
	public void addCommittee(Student name) {
		this.campCommittees.add(name);
	}

	/**
	 * Returns the value of visibility.
	 * @return
	 */
	public boolean getVisibility() {
		return this.visibility;
	}

	/**
	 * Toggle the visibility of the camp.
	 * @param visibility
	 */
	public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
	/**
	 * Return the array list of enquiries that students have for the camp.
	 * @return
	 */
	public ArrayList<Enquiry> getEnquiries() {
        return this.campEnquiries;
    }

	/**
	 * Return the array list of suggestions that camp committee submitted.
	 * @return
	 */
	public ArrayList<Suggestions> getSuggestions() {
        return this.campSuggestions;
    }

	/**
	 * Add the enquiry to array list of enquiries.
	 * @param anEnquiry
	 */
	public void addEnquiry(Enquiry anEnquiry) {
        this.campEnquiries.add(anEnquiry);
    }
	
	/**
	 * Add the suggestion to array list of Suggestions.
	 * @param aSuggestion
	 */
	public void addSuggestion(Suggestions aSuggestion) {
        this.campSuggestions.add(aSuggestion);
    }

	/**
	 * Prints out the array list of attendees.
	 */
	public void printAttendees() {
        System.out.println("Attendees: ");
        for (Student attendee : attendees) {
            System.out.println(attendee.getName());
        }
    }

	/**
	 * Prints out the array list of camp committee members.
	 */
	public void printCommitteeMembers() {
        System.out.println("Committee Members: ");
        for (Student committeeMember : campCommittees) {
            System.out.println(committeeMember.getName());
        }
    }

	/**
	 * Add the student to the blacklist array list.
	 * @param student
	 */
	public void addBlackList(Student student) {
		this.blackList.add(student);
	}

	/**
	 * Returns the arraylist of blacklist
	 * @return
	 */
	public ArrayList<Student> getBlackList() {
		return this.blackList;
	}
}