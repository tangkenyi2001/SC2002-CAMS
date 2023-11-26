package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Boundary.AdminHandlerMenu;
import Entity.Camp;
import Entity.Staff;
import Entity.Suggestions;
import Manager.SuggestionsManager;

public class StaffSuggestionsHandler implements AdminHandlerMenu{
    
    public static void view(Staff aStaff, int index){
		Scanner sc = new Scanner(System.in);
		ArrayList<Camp> createdCamps = aStaff.getCreatedCamps();
		Camp aCamp = createdCamps.get(index);
		ArrayList<Suggestions> thisSuggestion = aCamp.getSuggestions();
		if(thisSuggestion.isEmpty())
            System.out.println("No suggestions yet.");
		else{
            System.out.println("List of suggestions:");
			for (int i=0; i<thisSuggestion.size(); i++) {
				Suggestions curr = thisSuggestion.get(i);
				System.out.println("("+(i+1)+")" + curr.getContent());
			}
			System.out.println("Which suggestion would you like to approve?");
			System.out.println("Press <0> to return");
			int choice = sc.nextInt() - 1;
			if (choice == -1) return;
			process(thisSuggestion.get(choice));
		}
	}


	public static void process(Suggestions aSuggestion) {
		if(!aSuggestion.getApproval()){
				aSuggestion.setApproval();
				aSuggestion.setProcessedTrue();
				aSuggestion.getStudent().getCampCommittee().addPoints();
			System.out.println("Suggestion has been approved!");
		}
		else{
			System.out.println("Suggestion has already been approved!");
		}
		SuggestionsManager.update(aSuggestion);
		Updater.updateAll(aSuggestion.getCamp().getIC(),aSuggestion.getStudent(),null,aSuggestion,aSuggestion.getCamp());
	}
}
