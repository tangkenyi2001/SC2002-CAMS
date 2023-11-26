package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*;
import Entity.Enquiry;
import Entity.Suggestions;
import Serializer.*; 

public class SuggestionsManager implements Serializable {
    private static ArrayList<Suggestions> suggestions;
    static SuggestionsSerializer s = new SuggestionsSerializer(); 

public SuggestionsManager() {

    suggestions = SuggestionsSerializer.getSuggestions("SuggestionsDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (suggestions == null) {
        suggestions = new ArrayList<Suggestions>();
        }
}

public static void addSuggestion(Suggestions newSuggestion) {
    suggestions.add(newSuggestion);
    SuggestionsSerializer.saveSuggestions(suggestions, "SuggestionsDatabase.ser");
   // System.out.println("Suggestions Successfully Saved.");
}
public static ArrayList<Suggestions> getSuggestions() {
		//System.out.println("Retrieving Suggestions.");
		return suggestions;
	}
public static void clearSuggestion() {
    // Clear the student list
    suggestions.clear();

    // Save the empty list to the serialized file
    SuggestionsSerializer.saveSuggestions(suggestions, "SuggestionsDatabase.ser");
    //System.out.println("Suggestions Database Cleared.");
}

public static void update(Suggestions suggestion){
    int i=0;
    for (i=0;i<getSuggestions().size();i++)
                    {
                        if (suggestion.getStudentName().equals(getSuggestions().get(i).getStudentName()))
                        {
                            getSuggestions().set(i,suggestion);
                        }
                    }
                    SuggestionsSerializer.saveSuggestions(getSuggestions(), "SuggestionsDatabase.ser");
}
} 
