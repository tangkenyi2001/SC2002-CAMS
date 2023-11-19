package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*;
import Entity.Suggestions;
import Serializer.*; 

public class SuggestionsManager {
    private ArrayList<Suggestions> suggestions;
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
public void clearSuggestion() {
    // Clear the student list
    this.suggestions.clear();

    // Save the empty list to the serialized file
    SuggestionsSerializer.saveSuggestions(suggestions, "SuggestionsDatabase.ser");
    System.out.println("Suggestions Database Cleared.");
}
} 
