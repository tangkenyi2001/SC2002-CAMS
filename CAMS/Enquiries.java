public class Enquiries {

	private String studentName;
	private String content;
	private String reply;
	private String camp;
	private boolean processed = false;

	public String getStudentName() {
		return this.studentName;
	}

	public String getContent() {
		return this.content;
	}

	public String getReply() {
		return this.reply;
	}

	public String getCamp() {
		return this.camp;
	}

	/**
	 * 
	 * @param String
	 */
	public void setStudentName(String String) {
		this.studentName = String;
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
	public void setCamp(String String) {
		this.camp = String;
	}

}