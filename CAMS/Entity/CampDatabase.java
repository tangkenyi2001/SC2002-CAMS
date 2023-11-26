package Entity;
import java.util.ArrayList;

import Serializer.CampSerializer;

import java.io.Serializable; 

/**
 * Represents a CampDatabse.
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class CampDatabase implements Serializable{
   	 /**
     	 * ArrayList consisting of list of camps.
         */
	private static ArrayList<Camp> campList;
	static CampSerializer s = new CampSerializer();

	/**
        * Creates a new CampDatabase.
        */
	public CampDatabase(){
	campList = CampSerializer.getCamps("CampsDatabase.ser"); 
	if (campList == null) {
		campList = new ArrayList<Camp>();
		}
	/**
     	* Stores number of camps.
     	*/
	int numCamps = campList.size(); 
	}

	/**
        * Add camp and save to CampsDatabase serialized file.
	* @param newCamp to be added.
        */
	public static void addNewCamp(Camp newCamp) {
		campList.add(newCamp);
		CampSerializer.saveCamps(campList, "CampsDatabase.ser");
	}
	/**
        * Gets the ArrayList of camps
	* @return returns the ArrayList of camps
        */
	public static ArrayList<Camp> getCamp(){
		return CampDatabase.campList;
	}
	/**
        * Clear all the camps in the ArrayList.
	* Save Empty ArrayList to CampsDatabase serialized file.
        */
	public static void clearCamps() {
		CampDatabase.campList.clear();
		CampSerializer.saveCamps(campList, "CampsDatabase.ser");
	}
	/**
        * Update camp added to ArrayList and saved to CampsDatabase serialized file.
	* @param Camp to be updated.
        */
	public static void updateCamp(Camp camp){
		int i=0;
		for (i=0;i<getCamp().size();i++)
						{
							if (camp.getCampInfo().getCampName().equals(getCamp().get(i).getCampInfo().getCampName()))
							{
								getCamp().set(i,camp);
							}
						}
			CampSerializer.saveCamps(getCamp(), "CampsDatabase.ser");
	} 

	
	/**
        * Delete camp from ArrayList and save to CampsDatabase serialized file.
	* @param Camp to be deleted.
        */
	public static void deleteCamps(Camp aCamp) {
		campList.remove(aCamp);
		CampSerializer.saveCamps(campList, "CampsDatabase.ser");
		System.out.println("Camp Successfully Deleted.");
	}

}
