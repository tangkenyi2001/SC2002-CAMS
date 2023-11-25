<<<<<<< Updated upstream:CAMS/CampCommittee.java
public class CampCommittee{
=======
package Entity;
import java.io.Serializable;
import java.util.ArrayList;

public class CampCommittee implements Serializable{
>>>>>>> Stashed changes:CAMS/Entity/CampCommittee.java
	private Camp CommitteeOf;
	private int points;
	private ArrayList<Suggestions> submittedSuggestions;
	public CampCommittee(Camp camp) {
		this.CommitteeOf = camp;
		this.submittedSuggestions = new ArrayList<>();
		this.points=0;
	}

	public void printCommitteeMenu() {
		// TODO - implement CampCommittee.printComitteeMenu
		throw new UnsupportedOperationException();
	}

	public void printCommitteeOf() {
		// TODO - implement CampCommittee.PrintCommitteeOf
		throw new UnsupportedOperationException();
	}

	public Camp getCommitteeOf() {
		return this.CommitteeOf;
	}
	public void addPoints(){
		this.points++;
	}
	public void setPoints(int points){
		this.points = points;
	}
	public int getPoints(){
		return this.points;
	}
	public ArrayList<Suggestions> getSubmittedSuggestions(){
		return this.submittedSuggestions;
	}
}