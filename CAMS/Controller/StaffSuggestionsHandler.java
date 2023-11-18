package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Boundary.StaffHandlerMenu;
import Entity.Camp;
import Entity.Staff;
import Entity.Suggestions;

public class StaffSuggestionsHandler implements StaffHandlerMenu{
    
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
				System.out.println("("+(i+1)+") "+curr);
			}
			System.out.println("Which suggestion would you like to approve?");
			int choice = sc.nextInt() - 1;
			process(thisSuggestion.get(choice));
		}
	}


	public static void process(Suggestions aSuggestion) {
		if(!aSuggestion.getApproval()){
				aSuggestion.setApproval();
				aSuggestion.setProcessedTrue();
		}
		else{
			System.out.println("Suggestion has already been approved!");
		}
	}
}
