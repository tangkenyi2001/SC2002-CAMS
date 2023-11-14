import java.util.ArrayList;
public class Student extends User {
	private ArrayList<Camp> registeredCamps;
	private CampCommittee Committee;
	private ArrayList<Enquiry> submittedEnquiries;
	//private ArrayList<Enquiry> processedEnquiries;
	//Figure out how to include and manipulate processedEnquiries if neccessary
	public Student(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
	}

	public void viewRegistered() {
		for(int i = 0; i < registeredCamps.size(); i++){
			Camp camp = registeredCamps.get(i);
			System.out.println((i+1) + " " + camp.getCampInfo().getCampName());
		}
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