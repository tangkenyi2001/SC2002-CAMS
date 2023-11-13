import java.util.ArrayList;
public class Student extends User {
	private ArrayList<Camp> registeredCamps;
	private CampCommittee Committee;
	private ArrayList<Enquiry> submittedEnquiries;
	public void viewRegistered() {
		// TODO - implement Student.viewRegistered
		throw new UnsupportedOperationException();
	}
	public void setCampCommitee(CampCommittee committee){
		this.Committee = committee;
	}
	public CampCommittee getCampCommittee(){
		return this.Committee;
	}
	public ArrayList<Camp> getRegisteredCamps(){
		return this.registeredCamps;
	}
	public ArrayList<Enquiry> getEnquiries(){
		return this.submittedEnquiries;
	}
}