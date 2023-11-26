package Entity;
import java.util.*;

import Manager.StaffManager;
import Serializer.CampSerializer;

import java.io.Serializable;
/**
Represents a Staff.
Only a Staff can create camps.
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
*/
public class Staff extends User implements Serializable{
	/**
	 * Contains the array list of camps that the staff has created.
	 */
	private ArrayList<Camp> createdCamps = new ArrayList<>();
	// default constructor when staff is first initialised
	/**
	 * Constructor for the Staff.
	 * @param id id of the Staff.
	 * @param name Name of Staff.
	 * @param password	Password of staff.
	 * @param faculty Faculty of staff.
	 */
	public Staff(String id, String name, String password, String faculty) {
		super(id,name,password,faculty);
	}
	
	
	/**
	 * Prints out the list of camps that the staff has created.
	 */
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
	/**
	 * Adding the camp created to the array list.
	 */
	public void addToCreatedCamps(Camp aCamp){
		createdCamps.add(aCamp);
		
	}
	/**
	 * Returns the array list of camp created.
	 * @return
	 */
	public ArrayList<Camp>  getCreatedCamps(){
		return createdCamps;
	}
}