package Entity;

import java.util.Scanner;
import java.io.Serializable;
/**
Represents Suggestion made by Camp committee members.
Camp committee members can only submit suggestions to camps that they belong to.
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
*/
public class Suggestions implements Serializable {
	/**
	 * Student that this suggestion belong to.
	 */
	private Student student;
	/**
	 * Contains the content of the suggestion submitted.
	 */
	private String content;
	/**
	 * Contains the camp that this suggestion is meant for.
	 */
	private Camp camp;
	/**
	 * Contains whether the suggestion is approved.
	 * Only the Staff in charge of the camp can approve it.
	 */
	private boolean approval = false;
	/**
	 * Contains whether the suggestion is processed.
	 */
	private boolean processed=false;
	/**
	 * Constructor for the suggestion.
	 * @param student student that submitted the suggestion.
	 * @param camp camp that the suggestion is meant for.
	 */
	public Suggestions(Student student, Camp camp){
		Scanner sc =new Scanner(System.in);
		this.student= student;
		System.out.println("Content: ");
		this.content =sc.nextLine().toUpperCase();
		this.camp =camp;
		this.approval=false;
		this.processed=false;
	}
	/**
	 * Returns the student name.
	 * @return
	 */
	public String getStudentName() {
		return this.student.getName();
	}

	/**
	 * Returns the student object.
	 * @return
	 */
	public Student getStudent(){
		return this.student;
	}

	/**
	 * Returns the content of the suggestion.
	 * @return
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Return the camp.
	 * @return
	 */
	public Camp getCamp() {
		return camp;
	}

	/**
	 * Set the student.
	 * @param student Student that sent the suggestion.
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * Set the content.
	 * @param String content of the suggestion.
	 */
	public void setContent(String String) {
		this.content = String;
	}

	/**
	 * Set the camp.
	 * @param camp Camp that the suggestion is meant for.
	 */
	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	/**
	 * Returns approval.
	 * @return
	 */
	public boolean getApproval(){
		return this.approval;
	}
	/**
	 * Set the approval to true.
	 */
	public void setApproval(){
		this.approval=true;;
	}
	/**
	 * Set processed to true.
	 */
	public void setProcessedTrue(){
		this.processed = true;
	}

	/**
	 * Returns processed.
	 * @return
	 */
	public boolean getProcessed(){
		return this.processed;
	}

}