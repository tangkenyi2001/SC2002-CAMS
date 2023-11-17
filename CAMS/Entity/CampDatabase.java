package Entity;
import java.util.ArrayList;
public class CampDatabase {

	private static ArrayList<Camp> allCamps;

	public CampDatabase(){
		allCamps=new ArrayList<>();
	}

	public CampDatabase(int file){ //constructor for loading in a database file

	}

	public static ArrayList<Camp> getCamps() {
		return allCamps;
	}

	public static void addCamps(Camp aCamp) {
		allCamps.add(aCamp);
	}

}