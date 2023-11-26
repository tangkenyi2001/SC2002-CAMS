package Entity;
import java.util.ArrayList;
import java.io.Serializable; 
import Manager.StudentManager;

/**
Represents a Student
A Student can either be an attendee or a camp committee of a camp.
All students are by default attendees unless they registered to become a camp committee.
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
*/
public class Student extends User implements Serializable {
	/**
	 * Contains an array list of camps they have registered for.
	 */
	private ArrayList<Camp> registeredCamps;
	/**
	 * Contains the camp committee object that they registered for.
	 */
	private CampCommittee Committee;
	/**
	 * Contains an array list of enquiries that this student has submitted.
	 */
	private ArrayList<Enquiry> submittedEnquiries;

	/**
	 * Constructor for a student.
	 * @param id
	 * @param name
	 * @param password
	 * @param faculty
	 */
	public Student(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
		this.registeredCamps = new ArrayList<>();
    	this.submittedEnquiries = new ArrayList<>();
		this.Committee = null;

	}
	/**
	 * Prints out the array list of camps the student registered for.
	 * @param student
	 */
	public void viewRegistered(Student student) {
		if ( registeredCamps.isEmpty()){
			System.out.println("There are no camps registered!");
			return;
		}
		System.out.println("Registered Camps: ");
		int i = 1;
        for (Camp registeredCamp : registeredCamps){
			if(student.isCommittee()){
				if(student.getCampCommittee().getCommitteeOf().getCampInfo().getCampName().equals(registeredCamp.getCampInfo().getCampName())){
					System.out.print("(" + (i++)+") ");
					System.out.println("- "+registeredCamp.getCampInfo().getCampName()+" Registered as Committee");
				}
				else{
					System.out.print("(" + (i++)+") ");
					System.out.println("- "+registeredCamp.getCampInfo().getCampName()+" Registered as Attendee");
				}
			}
			else{
			System.out.print("(" + (i++)+") ");
			System.out.println("- "+registeredCamp.getCampInfo().getCampName()+" Registered as Attendee");
			}
		}
	}

	/**
	 * Set the camp committee.
	 * @param committee
	 */
	public void setCampCommittee(CampCommittee committee){
		this.Committee = committee;
	}
	/**
	 * Returns the camp committee.
	 * @return
	 */
	public CampCommittee getCampCommittee(){
		return this.Committee;
	}
	/**
	 * Returns the array list of registered camps.
	 * @return
	 */
	public ArrayList<Camp> getRegisteredCamps(){
		return this.registeredCamps;
	}
	/**
	 * Returns the array list of enquiries submitted.
	 * @return
	 */
	public ArrayList<Enquiry> getEnquiries(){
		return this.submittedEnquiries;
	}
	/**
	 * Returns the array list of suggestions submitted.
	 * @return
	 */
	public ArrayList<Suggestions> getSuggestions(){
		return this.getCampCommittee().getSubmittedSuggestions();
	}
	/**
	 * Returns whether this student is a camp committee member.
	 * @return
	 */
	public boolean isCommittee(){
		if(this.Committee == null){
			return false;
		}
		else{
			return true;
		}
	}

	/**
	 * Returns the points that this student has as a camp committee member
	 * @return
	 */
	public int getPoints(){
		return getCampCommittee().getPoints();
	}
}