package Entity;
import java.util.ArrayList;
import java.io.Serializable; 

public class Student extends User implements Serializable{
	private ArrayList<Camp> registeredCamps;
	private CampCommittee Committee;
	private ArrayList<Enquiry> submittedEnquiries;
	private ArrayList<Suggestions> submittedSuggestions;
	public Student(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
		this.registeredCamps = new ArrayList<>();
    	this.submittedEnquiries = new ArrayList<>();
		this.submittedSuggestions = new ArrayList<>();
		this.Committee = null;

	}
	public void viewRegistered() {
		System.out.println("Registered Camps: ");
		int i = 1;
    	if (registeredCamps != null) {
        for (Camp registeredCamp : registeredCamps) {
				System.out.print(i++);
				System.out.println(registeredCamp.getCampInfo().getCampName());
				}
			} else {
			System.out.println("No registered camps.");
		}
	}
	public void setCampCommittee(CampCommittee committee){
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
	public ArrayList<Suggestions> getSuggestions(){
		return this.submittedSuggestions;
	}
	public boolean isCommitee(){
		if(this.Committee == null){
			return false;
		}
		else{
			return true;
		}
	}
	public void setPoints(){
		int points = 0;
		for (int i=0; i<getSuggestions().size();i++ ){
			Suggestions a = getSuggestions().get(i);
			if(a.getApproval()== true){
				points += 1;
			}
			getCampCommittee().setPoints(points);
		}
	}

	public int getPoints(){
		setPoints();
		return getCampCommittee().getPoints();
	}
}