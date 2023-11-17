package Controller;
import java.util.Scanner;

import Entity.Camp;
import Entity.Student;
import Entity.Suggestions;

public class SuggestionHandler {

	public static void viewSuggestion(Student student) {
		System.out.println("Suggestions: ");
		int i=0;
		for (i=0;i<student.getSuggestions().size();i++){
			System.out.print(i+1);
			System.out.println(student.getSuggestions().get(i).getContent());
		}
		
	}
	public static void editSuggestion(Student student) {
		Scanner sc = new Scanner(System.in);
		SuggestionHandler.viewSuggestion(student);
		System.out.println("Which Suggestion would you like to edit?");
		int choice = sc.nextInt();
		if (student.getSuggestions().get(choice-1).getProcessed()==false)
		{
		System.out.println("Enter Edited Suggestion: ");
		String content=sc.nextLine();
		student.getSuggestions().get(choice-1).setContent(content);
//need to edit on camp end as well			 
		Camp camp=student.getCampCommittee().getCommitteeOf();
		int index=0;
		for (int j=0;j<camp.getSuggestions().size();j++)
		{
			if (camp.getSuggestions().get(j).getStudentName().equals(student.getName()))
			{
				index++;
				if (index==choice){
					break;
				}
			}
		}
		camp.getSuggestions().get(index).setContent(content);
		}else{
			System.out.println("Suggestion has been processed, unable to edit.");
		}

		
	}
	public static void deleteSuggestion(Student student) {
		Scanner sc = new Scanner(System.in);
		SuggestionHandler.viewSuggestion(student);
		System.out.println("Which Suggestion would you like to delete?");
		int choice = sc.nextInt();
		if (student.getSuggestions().get(choice-1).getProcessed()==false)
		{
		System.out.println("Enter Suggestion to delete: ");
		String content=sc.nextLine();
		student.getSuggestions().remove(choice-1);
		//need to edit on camp end as well			 
		Camp camp=student.getCampCommittee().getCommitteeOf();
		int index=0;
		for (int j=0;j<camp.getSuggestions().size();j++)
		{
			if (camp.getSuggestions().get(j).getStudentName()==student.getName())
			{
				index++;
				if (index==choice){
					break;
				}
			}
		}
		camp.getSuggestions().remove(index);
		}else{
			System.out.println("Suggestion has been processed, unable to delete.");
		}
	}

	/**
	 * 
	 * @param Suggestion
	 */
	public void submitSuggestions(Student student) {
		Suggestions newSuggestions;
		newSuggestions= new Suggestions();
		//Suggestion has been created, now need to update into both the student and camp
		student.getSuggestions().add(newSuggestions);
		//updated to students
		student.getCampCommittee().getCommitteeOf().getSuggestions().add(newSuggestions);
		//updated to the camps
	}

}