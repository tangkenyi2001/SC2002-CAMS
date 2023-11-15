import java.util.*;

public class Staff extends User {

	private ArrayList<Camp> createdCamps = new ArrayList<>();

	// default constructor when staff is first initialised
	public Staff(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
	}
	
	// need to have constructor for existing user
	

	public void viewCreatedCamps() {
		if (createdCamps.isEmpty()) {
            System.out.println("No camps created yet.");
        } else {
            System.out.println("List of Created Camps:");
            for (Camp camp : createdCamps) {
                System.out.println("Camp Name: " + camp.getCampInfo().getCampName());
			}
		}
	}
	
	public void addToCreatedCamps(Camp aCamp){
		createdCamps.add(aCamp);
	}

	public ArrayList<Camp> getCreatedCamps(){
		return createdCamps;
	}
}