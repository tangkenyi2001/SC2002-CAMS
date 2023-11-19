package Entity;
import java.util.ArrayList;

import Serializer.CampSerializer;

import java.io.Serializable; 

public class CampDatabase implements Serializable{

	private static ArrayList<Camp> allCamps;
	static CampSerializer s = new CampSerializer();

	public CampDatabase(){
		allCamps = CampSerializer.getCamps("CampsDatabase.ser");
		if(allCamps==null){ 
			allCamps=new ArrayList<Camp>();
		}
	}

	public static ArrayList<Camp> getCamps() {
		System.out.println("Retrieving Camps.");
		return allCamps;
	}

	public static void addCamps(Camp aCamp) {
		allCamps.add(aCamp);
		CampSerializer.saveCamps(allCamps, "CampsDatabase.ser");
		System.out.println("Camps Successfully Saved.");
	}
	

}