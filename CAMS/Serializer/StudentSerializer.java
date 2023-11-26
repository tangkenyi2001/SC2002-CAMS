package Serializer;

import java.util.ArrayList;
import java.io.*;
import Controller.*;
import Entity.*; 
/**
 * Represents a StudentSerializer.
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */

public class StudentSerializer extends Serializer {
    public StudentSerializer() {
        super();
    }

    
    /**
     * save ArrayList of students to serialized file.
     * @param o is the ArrayList of students to be Saved.
     * @param filename is the StudentsDatabase Serialized file.
     */
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

     /**
     * Retrieve ArrayList of students from serialized file.
     * @param filename is the StudentsDatabase Serialized file.
     */
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
