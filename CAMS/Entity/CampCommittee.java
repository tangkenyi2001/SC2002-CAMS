package Entity;
import java.io.Serializable;
import java.util.ArrayList;

public class CampCommittee implements Serializable{
	private Camp CommitteeOf;
	private int points;
	private ArrayList<Suggestions> submittedSuggestions;
	public CampCommittee(Camp camp) {
		super();
		this.CommitteeOf = camp;
		this.submittedSuggestions = new ArrayList<>();
		this.points=0;
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