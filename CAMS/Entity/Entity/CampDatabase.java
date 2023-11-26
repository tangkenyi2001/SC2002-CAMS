package Entity;
import java.util.ArrayList;

import Serializer.CampSerializer;

import java.io.Serializable; 

public class CampDatabase implements Serializable{

	private static ArrayList<Camp> campList;
	static CampSerializer s = new CampSerializer();

	public CampDatabase(){
	campList = CampSerializer.getCamps("CampsDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
	if (campList == null) {
		campList = new ArrayList<Camp>();
		}
	int numCamps = campList.size(); // not sure if necessary , to store number of camps // 
	}
	
	public static void addNewCamp(Camp newCamp) {
		campList.add(newCamp);
		CampSerializer.saveCamps(campList, "CampsDatabase.ser");
		//System.out.println("Camps Successfully Saved.");
	}
	public static ArrayList<Camp> getCamp(){
		return CampDatabase.campList;
	}
	public static void clearCamps() {
		// Clear the student list
		CampDatabase.campList.clear();
	
		// Save the empty list to the serialized file
		CampSerializer.saveCamps(campList, "CampsDatabase.ser");
		//System.out.println("Camp Database Cleared.");
	}
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
	

	public static void deleteCamps(Camp aCamp) {
		campList.remove(aCamp);
		CampSerializer.saveCamps(campList, "CampsDatabase.ser");
		System.out.println("Camp Successfully Deleted.");
	}

}