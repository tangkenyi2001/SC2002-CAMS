import java.util.ArrayList;
public class Student extends User {
	private ArrayList<Camp> registeredCamps;
	private CampCommittee Committee;
	private ArrayList<Enquiry> submittedEnquiries;
	public Student(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
		this.registeredCamps = new ArrayList<>();
    	this.submittedEnquiries = new ArrayList<>();
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
}