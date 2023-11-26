package Entity;
import java.util.ArrayList;
import java.io.Serializable; 
import Manager.StudentManager;

public class Student extends User implements Serializable {
	private ArrayList<Camp> registeredCamps;
	private CampCommittee Committee;
	private ArrayList<Enquiry> submittedEnquiries;
	public Student(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
		this.registeredCamps = new ArrayList<>();
    	this.submittedEnquiries = new ArrayList<>();
		this.Committee = null;

	}
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
		return this.getCampCommittee().getSubmittedSuggestions();
	}

	public boolean isCommittee(){
		if(this.Committee == null){
			return false;
		}
		else{
			return true;
		}
	}


	public int getPoints(){
		return getCampCommittee().getPoints();
	}
}