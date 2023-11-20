package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*;
import Entity.Enquiry;
import Entity.Suggestions;
import Serializer.*; 

public class SuggestionsManager {
    private static ArrayList<Suggestions> suggestions;
    static SuggestionsSerializer s = new SuggestionsSerializer(); 

public SuggestionsManager() {

    suggestions = SuggestionsSerializer.getSuggestions("SuggestionsDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (suggestions == null) {
        suggestions = new ArrayList<Suggestions>();
        }
}

public void addSuggestion(Suggestions newSuggestion) {
    suggestions.add(newSuggestion);
    SuggestionsSerializer.saveSuggestions(suggestions, "SuggestionsDatabase.ser");
    System.out.println("Suggestions Successfully Saved.");
}
public static ArrayList<Suggestions> getSuggestions() {
		System.out.println("Retrieving Suggestions.");
		return suggestions;
	}
public void clearSuggestion() {
    // Clear the student list
    this.suggestions.clear();

    // Save the empty list to the serialized file
    SuggestionsSerializer.saveSuggestions(suggestions, "SuggestionsDatabase.ser");
    //System.out.println("Suggestions Database Cleared.");
}
} 
