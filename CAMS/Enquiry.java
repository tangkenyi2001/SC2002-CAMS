<<<<<<< Updated upstream:CAMS/Enquiry.java
public class Enquiry{
=======
package Entity;
import java.io.Serializable;
import java.util.Scanner; 

public class Enquiry implements Serializable{
>>>>>>> Stashed changes:CAMS/Entity/Enquiry.java

	private Student student;
	private String content;
	private String reply;
	private Camp camp;
	private boolean processed;
	private User replier;

	public Enquiry(Student student , String content, Camp camp){
		this.student = student;
		this.content = content;
		this.camp = camp;
		this.reply = null;
		this.processed=false;
		this.replier = null;
	}

	public Student getStudent() {
		return this.student;
	}

	public String getContent() {
		return this.content;
	}

	public String getReply() {
		return this.reply;
	}

	public Camp getCamp() {
		return this.camp;
	}

	/**
	 * 
	 * @param String
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * 
	 * @param String
	 */
	public void setContent(String String) {
		this.content = String;
	}

	/**
	 * 
	 * @param String
	 */
	public void setReply(String String) {
		this.reply = String;
	}

	/**
	 * 
	 * @param String
	 */
	public void setCamp(Camp camp) {
		this.camp = camp;
	}

	public void setProcessedTrue(){
		this.processed = true;
	}

	public boolean getProcessed(){
		return this.processed;
	}

	public void setReplier(User user){
		this.replier = user;
	}

	public User getReplier(){
		return replier;
	}

	
}