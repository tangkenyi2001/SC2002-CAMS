package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*; 
import Entity.*;
import Serializer.*; 

public class CampManager {
    private ArrayList<Camp> campList;
    private int numCamps; 
    static CampSerializer s = new CampSerializer();


public CampManager() {

    campList = CampSerializer.getCamps("CampsDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (campList == null) {
        campList = new ArrayList<Camp>();
        }
    numCamps = campList.size(); // not sure if necessary , to store number of camps // 
}

public void addNewCamp(Camp newCamp) {
    campList.add(newCamp);
    CampSerializer.saveCamps(campList, "CampsDatabase.ser");
    System.out.println("Camps Successfully Saved.");
}
public ArrayList<Camp> getCamp(){
    return this.campList;
}

} 

