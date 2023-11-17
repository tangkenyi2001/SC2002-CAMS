package Serializer;

import java.util.ArrayList;
import java.io.*;

// not sure if the import statement below is correct // 
// may need to edit on your local device for consistency // 
import Controller.*; 

public class CampSerializer extends Serializer {
    public CampSerializer() {
        super();
    }

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

    public static ArrayList<Camp> getCamps(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Camp> camps = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            camps = ((ArrayList<Camp>) os.readObject()); // type safety but i think does not matter // 
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