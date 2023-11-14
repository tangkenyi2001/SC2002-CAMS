import java.util.*;
class ViewHandler {
	public void viewAvailable() {
		// TODO - implement ViewHandler.viewAvailable
		throw new UnsupportedOperationException();
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