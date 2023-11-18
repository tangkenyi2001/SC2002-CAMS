package Entity;
import java.util.*;

public class Staff extends User {

	private ArrayList<Camp> createdCamps = new ArrayList<>();
	// default constructor when staff is first initialised
	public Staff(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
	}
	
	// need to have constructor for existing user
	

	
	public void addToCreatedCamps(Camp aCamp){
		createdCamps.add(aCamp);
	}

	public ArrayList<Camp> getCreatedCamps(){
		return createdCamps;
	}
}