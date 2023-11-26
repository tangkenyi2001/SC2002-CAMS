package Serializer;

import java.util.ArrayList;
import java.io.*;
import Controller.*; 
import Entity.*;
/**
 * Represents a StaffSerializer.
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class StaffSerializer extends Serializer {
    public StaffSerializer() {
        super();
    }

     /**
     * save ArrayList of staff to serialized file.
     * @param o is the ArrayList of staffs to be Saved.
     * @param filename is the StaffsDatabase Serialized file.
     */
    public static void saveStaffs(ArrayList<Staff> o, String filename) {
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
     * Retrieve ArrayList of staffs from serialized file.
     * @param filename is the StaffsDatabase Serialized file.
     */
    public static ArrayList<Staff> getStaffs(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Staff> staffs = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            staffs = ((ArrayList<Staff>) os.readObject()); 
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
        return staffs;
    }
}
