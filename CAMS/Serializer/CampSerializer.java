package Serializer;

import java.util.ArrayList;
import java.io.*;
import Controller.*;
import Entity.Camp; 


/**
 * Represents a CampSerializer.
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class CampSerializer extends Serializer {
    public CampSerializer() {
        super();
    }

     /**
     * save ArrayList of camps to serialized file.
     * @param o is the ArrayList of camps to be Saved.
     * @param filename is the CampsDatabase Serialized file.
     */


    public static void saveCamps(ArrayList<Camp> o, String filename) {
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
     * Retrieve ArrayList of camps from serialized file.
     * @param filename is the CampsDatabase Serialized file.
     */
    public static ArrayList<Camp> getCamps(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Camp> camps = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            camps = ((ArrayList<Camp>) os.readObject()); 
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
        return camps;
    }
}
