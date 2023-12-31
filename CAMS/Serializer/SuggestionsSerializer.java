package Serializer;

import java.util.ArrayList;
import java.io.*;
import Controller.*; 
import Entity.Suggestions;


/**
 * Represents a SuggestionsSerializer.
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class SuggestionsSerializer extends Serializer {
    public SuggestionsSerializer() {
        super();
    }

     /**
     * save ArrayList of Suggestions to serialized file.
     * @param o is the ArrayList of Suggestions to be Saved.
     * @param filename is the SuggestionsDatabase Serialized file.
     */

    public static void saveSuggestions(ArrayList<Suggestions> o, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

     /**
     * Retrieve ArrayList of Suggestions from serialized file.
     * @param filename is the SuggestionsDatabase Serialized file.
     */
    public static ArrayList<Suggestions> getSuggestions(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Suggestions> suggestions = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            suggestions = ((ArrayList<Suggestions>) os.readObject()); // type safety but does not matter // 
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
        } catch (EOFException e) {
            // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
        } catch (IOException e) {
            // e.printStackTrace();
        } catch (Exception e) {
            // e.printStackTrace();
        } finally {
            try {
                os.close();
                fi.close();
            } catch (Exception e) {
                // if this fails, it's probably open, so just do nothing
            }
        }
        return suggestions;
    }
}
