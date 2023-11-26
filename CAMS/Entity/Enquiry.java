package Entity;
import java.io.Serializable;
import java.util.Scanner; 
/**
Represents the enquiry that an attendee submitted.
Many enquiries can be submitted by an attendee.
Every enquiry belongs to a camp.
Only an attendee can submit enquiries. Camp Committee members of the camp are unable to.
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
*/
public class Enquiry implements Serializable{
	/**
	 * Student that made the enquiry.
	 */
	private Student student;
	/**
	 * Content of the enquiry submitted by attendees.
	 */
	private String content;
	/**
	 * The reply that a Staff or Camp Committee gave with regards to the enquiry made by attendees.
	 */
	private String reply;
	/**
	 * Camp that the enquiry is meant for.
	 */
	private Camp camp;
	/**
	 * Mark whether the enquiry has been processed. 
	 * Replying a enquiry denotes processing the enquiry.
	 */
	private boolean processed;
	/**
	 * Contains either Staff or Committee member, depending on who is the one that processed/reply the enquiry.
	 */
	private User replier;

	/**
	 * Constructor for the enquiry.
	 * @param student This student object
	 * @param content The content that student wants to submit
	 * @param camp	Camp that the enquiry is meant for
	 */
	public Enquiry(Student student , String content, Camp camp){
		this.student = student;
		this.content = content;
		this.camp = camp;
		this.reply = null;
		this.processed=false;
		this.replier = null;
	}

	/**
	 * Return the Student.
	 * @return
	 */
	public Student getStudent() {
		return this.student;
	}
	/**
	 * Return the content of enquiry.
	 * @return
	 */
	public String getContent() {
		return this.content;
	}
	/**
	 * Return the reply of enquiry.
	 * @return
	 */
	public String getReply() {
		return this.reply;
	}
	/**
	 * Return the camp that this enquiry is meant for.
	 * @return
	 */
	public Camp getCamp() {
		return this.camp;
	}

	/**
	 * Set the student who made the enquiry.
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * Set the content of the enquiry.
	 * @param String Content of the enquiry
	 */
	public void setContent(String String) {
		this.content = String;
	}

	/**
	 * Set the reply to the enquiry.
	 * @param String Reply to the enquiry
	 */
	public void setReply(String String) {
		this.reply = String;
	}

	/**
	 * Set the camp that the enquiry is meant for.
	 * @param camp
	 */
	public void setCamp(Camp camp) {
		this.camp = camp;
	}
	/**
	 * Set Processed attribute to True.
	 */
	public void setProcessedTrue(){
		this.processed = true;
	}

	/**
	 * Return the processed attribute.
	 * @return
	 */
	public boolean getProcessed(){
		return this.processed;
	}
	/**
	 * Set the replier.
	 * @param user the user that replied
	 */
	public void setReplier(User user){
		this.replier = user;
	}
	/**
	 * Returns the replier.
	 * @return
	 */
	public User getReplier(){
		return replier;
	}

	
}