package Serializer;

import java.util.ArrayList;

import Controller.*; // this line may need to change accordingly to your own device //
import Entity.Enquiry;

import java.io.*;

public class EnquiriesSerializer extends Serializer {
    public EnquiriesSerializer() {
        super();
    }

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

    public static ArrayList<Enquiry> getEnquiries(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Enquiry> enquiries = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            enquiries = ((ArrayList<Enquiry>) os.readObject()); // type safety but i think it does not matter // 
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