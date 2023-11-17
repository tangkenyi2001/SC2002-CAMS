package Serializer;

import java.util.ArrayList;
import java.io.*;
import Controller.*; // this line may need to change accordingly to your own device //

public class StudentSerializer extends Serializer {
    public StudentSerializer() {
        super();
    }

    public static void saveStudents(ArrayList<Student> o, String filename) {
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

    public static ArrayList<Student> getStudents(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Student> students = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            students = ((ArrayList<Student>) os.readObject()); // type safety but i think does not matter // 
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
        return students;
    }
}