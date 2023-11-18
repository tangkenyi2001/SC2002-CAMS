package Serializer;

import java.util.ArrayList;
import java.io.*;
import Controller.*; // this line may need to change accordingly to your own device //
import Entity.*;
public class StaffSerializer extends Serializer {
    public StaffSerializer() {
        super();
    }

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

    public static ArrayList<Staff> getStaffs(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Staff> staffs = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            staffs = ((ArrayList<Staff>) os.readObject()); // type safety but i think does not matter // 
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
