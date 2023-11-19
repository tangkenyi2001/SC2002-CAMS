package Entity;
import java.io.Serializable;

public class CampCommittee implements Serializable{
	private Camp CommitteeOf;
	private int points;
	public CampCommittee(Camp camp) {
		super();
		this.CommitteeOf = camp;
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
}