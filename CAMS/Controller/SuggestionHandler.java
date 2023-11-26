package Controller;
import java.util.ArrayList;
import java.util.Scanner;

import Entity.Camp;
import Entity.CampDatabase;
import Entity.Enquiry;
import Entity.Staff;
import Entity.Student;
import Entity.Suggestions;
import Manager.StaffManager;
import Manager.StudentManager;
import Manager.SuggestionsManager;
import Serializer.SuggestionsSerializer;

public class SuggestionHandler {

	public static void viewSuggestion(Student student) {
		int i=0;
		if(student.getSuggestions().isEmpty()){
			System.out.println("You have not submitted any suggestions.");
		}
		else{
			System.out.println("Suggestions: ");
			for (i=0;i<student.getSuggestions().size();i++){
				System.out.print("(" + (i+1) + ") ");
				System.out.println(student.getSuggestions().get(i).getContent());
			}
		}
		
	}

	public static void editSuggestion(Student student) {
		Scanner sc = new Scanner(System.in);
		SuggestionHandler.viewSuggestion(student);
		if (!student.getSuggestions().isEmpty()){
			System.out.println("Which Suggestion would you like to edit?");
			System.out.println("Enter <0> to cancel");
			int choice = sc.nextInt()-1;
			sc.nextLine();
			if (choice == -1) return;
			Suggestions suggestionToEdit=student.getSuggestions().get(choice);
			if (!suggestionToEdit.getProcessed())
			{
			System.out.println("Enter Edited Suggestion: ");
			String content=sc.nextLine().toUpperCase();
			student.getSuggestions().get(choice).setContent(content);
			//need to edit on camp end as well			 
			/*Camp camp=student.getCampCommittee().getCommitteeOf();
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
			}*/
			//camp.getSuggestions().get(index).setContent(content);
			CampDatabase.updateCamp(student.getCampCommittee().getCommitteeOf());
			SuggestionsSerializer.saveSuggestions(student.getSuggestions(), "SuggestionsDatabase.ser");
			StudentManager.updateStudents(student);
			StaffManager.updateStaff(student.getCampCommittee().getCommitteeOf().getIC());
			Updater.updateAll(suggestionToEdit.getCamp().getIC(),student,null,suggestionToEdit,suggestionToEdit.getCamp());
						}

			else{
				System.out.println("Suggestion has been processed, unable to edit.");
			}
		}
		
	}
	public static void deleteSuggestion(Student student) {
		Scanner sc = new Scanner(System.in);
		SuggestionHandler.viewSuggestion(student);
		if (!student.getSuggestions().isEmpty()){
			System.out.println("Which Suggestion would you like to delete?");
			System.out.println("Enter <0> to cancel");
			int choice = sc.nextInt()-1;
			if (choice == -1) return;
			if (student.getSuggestions().get(choice).getProcessed())
			{
				System.out.println("Suggestion has been processed, unable to delete.");
				return;
			}
			if (!student.getSuggestions().get(choice).getProcessed())
			{
			Suggestions suggestionToDelete = student.getSuggestions().get(choice);
			int index = student.getCampCommittee().getCommitteeOf().getSuggestions().indexOf(suggestionToDelete);
			student.getSuggestions().remove(choice);
			student.getCampCommittee().getCommitteeOf().getSuggestions().remove(index);
			//need to edit on camp end as well			 
			Camp camp=student.getCampCommittee().getCommitteeOf();
			CampDatabase.updateCamp(student.getCampCommittee().getCommitteeOf());
			SuggestionsSerializer.saveSuggestions(camp.getSuggestions(), "SuggestionsDatabase.ser");
			StudentManager.updateStudents(student);
			StaffManager.updateStaff(camp.getIC());
			}else{
				System.out.println("Suggestion has been processed, unable to delete.");
			}
		}
	}

	public static void submitSuggestions(Student student) {
		Suggestions newSuggestions;
		newSuggestions= new Suggestions(student,student.getCampCommittee().getCommitteeOf());
		//Suggestion has been created, now need to update into both the student and camp
		student.getSuggestions().add(newSuggestions);
		//updated to students
		Camp aCamp = student.getCampCommittee().getCommitteeOf();
		student.getCampCommittee().getCommitteeOf().getSuggestions().add(newSuggestions);
		CampDatabase.updateCamp(student.getCampCommittee().getCommitteeOf());
		SuggestionsManager.update(newSuggestions);
		StudentManager.updateStudents(student);
		StaffManager.updateStaff(aCamp.getIC());
		//updated to the camps
	}
}