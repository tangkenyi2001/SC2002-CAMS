public class CampCommittee{
	private Camp CommitteeOf;
	private int points;
	public CampCommittee(Camp camp) {
		this.CommitteeOf = camp;
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
}