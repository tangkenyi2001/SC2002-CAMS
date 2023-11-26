package Serializer;

import java.util.ArrayList;

import Controller.*; 
import Entity.Enquiry;

import java.io.*;
/**
 * Represents a EnquiriesSerializer.
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class EnquiriesSerializer extends Serializer {
    /**
     * Creates an EnquiriesSerializer.
     */
    public EnquiriesSerializer() {
        super();
    }

     /**
     * save ArrayList of enquiries to serialized file.
     * @param o is the ArrayList of enquiries to be Saved.
     * @param filename is the EnquiriesDatabase Serialized file.
     */
    public static void saveEnquiries(ArrayList<Enquiry> o, String filename) {
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
     * Retrieve ArrayList of enquiries from serialized file.
     * @param filename is the EnquiriesDatabase Serialized file.
     */

    public static ArrayList<Enquiry> getEnquiries(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Enquiry> enquiries = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            enquiries = ((ArrayList<Enquiry>) os.readObject()); 
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
        return enquiries;
    }
}
