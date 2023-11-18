package Entity;

import java.util.Scanner;

public class Suggestions {

	private String studentName;
	private String content;
	private String camp;
	private boolean approval = false;
	private boolean processed=false;
	public Suggestions(){
		Scanner sc =new Scanner(System.in);
		System.out.println("Student Name: ");
		this.studentName=sc.nextLine().toUpperCase();
		System.out.println("Content: ");
		this.content =sc.nextLine().toUpperCase();
		System.out.println("Camp: ");
		this.camp =sc.nextLine().toUpperCase();
		this.approval=false;
		this.processed=false;
	}
	public String getStudentName() {
		return this.studentName;
	}

	public String getContent() {
		return this.content;
	}

	public String getCamp() {
		return this.camp;
	}

	public void setStudentName(String String) {
		this.studentName = String;
	}

	public void setContent(String String) {
		this.content = String;
	}
	public void setCamp(String String) {
		this.camp = String;
	}

	public boolean getApproval(){
		return this.approval;
	}
	public void setApproval(){
		this.approval=true;;
	}
	public void setProcessedTrue(){
		this.processed = true;
	}

	public boolean getProcessed(){
		return this.processed;
	}

}