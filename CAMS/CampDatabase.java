import java.util.ArrayList;
public class CampDatabase {

	private ArrayList<Camp> allCamps;

	CampDatabase(){
		this.allCamps=new ArrayList<>();
	}
	public ArrayList<Camp> getCamps() {
		return allCamps;
	}

	public void addCamps() {
		Camp aCamp=new Camp();
		this.allCamps.add(aCamp);
	}

}