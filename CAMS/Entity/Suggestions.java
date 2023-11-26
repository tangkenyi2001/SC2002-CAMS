package Entity;

import java.util.Scanner;
import java.io.Serializable;

public class Suggestions implements Serializable {

	private Student student;
	private String content;
	private Camp camp;
	private boolean approval = false;
	private boolean processed=false;
	public Suggestions(Student student, Camp camp){
		Scanner sc =new Scanner(System.in);
		this.student= student;
		System.out.println("Content: ");
		this.content =sc.nextLine().toUpperCase();
		this.camp =camp;
		this.approval=false;
		this.processed=false;
	}
	public String getStudentName() {
		return this.student.getName();
	}
	public Student getStudent(){
		return this.student;
	}

	public String getContent() {
		return this.content;
	}

	public Camp getCamp() {
		return camp;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setContent(String String) {
		this.content = String;
	}
	public void setCamp(Camp camp) {
		this.camp = camp;
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