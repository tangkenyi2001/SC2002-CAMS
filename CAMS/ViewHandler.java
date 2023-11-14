import java.util.*;
class ViewHandler {
	//Prints camps student can register for
	public static ArrayList<Camp> viewRegisterAvailable(Student student){
		ArrayList<Camp> campList = new ArrayList<>(CampDatabase.getCamps());
		ArrayList<Camp> availableCamps = new ArrayList<>();
		Camp camp;
		for(int i = 0; i < campList.size(); i++){
			camp = campList.get(i);
			if((student.getFaculty().toUpperCase() == camp.getCampInfo().getUserGroup() && !student.getRegisteredCamps().contains(camp)) || (camp.getCampInfo().getUserGroup() == "ANY" && !student.getRegisteredCamps().contains(camp))){
				System.out.println("("+ (i+1) + ") " + camp.getCampInfo().getCampName());
				availableCamps.add(camp);
			}
		}
		return availableCamps;
	}
	//Prints camps student can enquire about (includes registered camps) What if camp committee camp? Can they enquire about camp they are in charge of?
	public static ArrayList<Camp> viewEnquiryAvailable(Student student){
		ArrayList<Camp> campList = new ArrayList<>(CampDatabase.getCamps());
		ArrayList<Camp> availableCamps = new ArrayList<>();
		Camp camp;
		for(int i = 0; i < campList.size(); i++){
			camp = campList.get(i);
			if(student.getFaculty().toUpperCase() == camp.getCampInfo().getUserGroup() || camp.getCampInfo().getUserGroup() == "ANY"){
				System.out.println("("+ (i+1) + ") " + camp.getCampInfo().getCampName());
				availableCamps.add(camp);
			}
		}
		return availableCamps;
	}
	//Prints available camp slots excluding registered camps, check again committee camp isit in registered camps?
	public static void viewAvailableSlots(Student student){
		ArrayList<Camp> campList = new ArrayList<>(CampDatabase.getCamps());
		Camp camp;
		for(int i = 0; i < campList.size(); i++){
			camp = campList.get(i);
			if((student.getFaculty().toUpperCase() == camp.getCampInfo().getUserGroup() && !student.getRegisteredCamps().contains(camp)) || (camp.getCampInfo().getUserGroup() == "ANY" && !student.getRegisteredCamps().contains(camp))){
				System.out.println("("+ (i+1) + ") " + camp.getCampInfo().getCampName());
				System.out.println("Number of attendee slots: " + camp.getCampInfo().getAttendeeSlots());
				System.out.println("Number of committee slots: " + camp.getCampInfo().getCommitteeSlots());
			}
		}
	}
	public static void viewAll() {
		ArrayList<Camp> camps;
		camps = CampDatabase.getCamps(); 
		if (camps.isEmpty()) {
            System.out.println("There are no camps");
        } else {
            System.out.println("List of all camps:");
            for (Camp camp : camps) {
                System.out.println("Camp Name: " + camp.getCampInfo().getCampName());
			}
		}
	}
}