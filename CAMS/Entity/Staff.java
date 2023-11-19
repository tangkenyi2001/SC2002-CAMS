package Entity;
import java.util.*;
import java.io.Serializable;

public class Staff extends User implements Serializable{

	private ArrayList<Camp> createdCamps = new ArrayList<>();
	// default constructor when staff is first initialised
	public Staff(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
	}
	
	// need to have constructor for existing user
	

	public void viewCreatedCamps() {
		int i = 0;
		if (createdCamps.isEmpty()) {
            System.out.println("You have not created any camps yet.");
        } else {
            System.out.println("List of Created Camps:");
            for (Camp camp : createdCamps) {
				i +=1;
                System.out.println("("+i+")" + " Camp Name: " + camp.getCampInfo().getCampName());
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