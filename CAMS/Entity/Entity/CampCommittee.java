package Entity;
/**
Represents a Camp Committee member.
A Student can only be a camp committee of one camp.
A Student will automatically become a camp committee as long as he registers for that role.
A Camp Committee Member can still be attendees for other camps.
A Camp Committee Member have several adminstrative rights for the camps such as replying to students enquiries as well as making suggestions
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
*/
import java.io.Serializable;
import java.util.ArrayList;

public class CampCommittee implements Serializable{
	/**
	 * Camp that the student is Camp Committee of.
	 */
	private Camp CommitteeOf;
	/**
	 * Points of the Camp Committee
	 */
	private int points;
	/**
	 * Array List of suggestions that the committee member has submitted.
	 */
	private ArrayList<Suggestions> submittedSuggestions;

	/**
	 * Constructor for Camp Committee member.
	 * @param camp
	 */
	public CampCommittee(Camp camp) {
		super();
		this.CommitteeOf = camp;
		this.submittedSuggestions = new ArrayList<>();
		this.points=0;
	}

	/**
	 * Returns the camp that the student is a committe member of
	 * @return
	 */
	public Camp getCommitteeOf() {
		return this.CommitteeOf;
	}
	/**
	 * Increase points by 1.
	 */
	public void addPoints(){
		this.points++;
	}
	/**
	 * Set the points
	 * @param points
	 */
	public void setPoints(int points){
		this.points = points;
	}
	/**
	 * Returns the number of points this student has.
	 * @return
	 */
	public int getPoints(){
		return this.points;
	}
	/**
	 * Returns the array list of suggestions that this committee member has made
	 * @return
	 */
	public ArrayList<Suggestions> getSubmittedSuggestions(){
		return this.submittedSuggestions;
	}
}