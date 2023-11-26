package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*;
import Entity.Enquiry;
import Entity.Suggestions;
import Serializer.*; 
/**
 * Represents a SuggestionsManager.
 * 
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class SuggestionsManager {
	/**
	* ArrayList consisting of suggestions.
	*/
    private static ArrayList<Suggestions> suggestions;
    static SuggestionsSerializer s = new SuggestionsSerializer(); 

     /**
     * Creates a new SuggestionsManager.
     */
public SuggestionsManager() {

    suggestions = SuggestionsSerializer.getSuggestions("SuggestionsDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (suggestions == null) {
        suggestions = new ArrayList<Suggestions>();
        }
}

    /**
     * Adds newSuggestion to ArrayList, saves this suggestion to SuggestionsDatabase serialized file.
     * @param newSuggestion that is to be added to ArrayList of suggestions.
     */
public static void addSuggestion(Suggestions newSuggestion) {
    suggestions.add(newSuggestion);
    SuggestionsSerializer.saveSuggestions(suggestions, "SuggestionsDatabase.ser");
}
     /**
     * Gets the ArrayList of suggestions.
     * @return returns the ArrayList of suggestions.
     */
public static ArrayList<Suggestions> getSuggestions() {
		return suggestions;
	}

     /**
     * Clears the ArrayList of Suggestions.
     * Saves the empty ArrayList of Suggestions to SuggestionsDatabase serialized file. 
     */
public static void clearSuggestion() {
    suggestions.clear();
    SuggestionsSerializer.saveSuggestions(suggestions, "SuggestionsDatabase.ser");
}

    /**
     * @param suggestion to be updated. 
     * Suggestion to be updated is saved to SuggestionsDatabase serialized file.
     */
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
