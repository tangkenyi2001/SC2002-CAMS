package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*; 
import Entity.*;

import Serializer.*; 

public class StudentManager implements Serializable {
    private static ArrayList<Student> students ;
    static StudentSerializer s = new StudentSerializer();


public StudentManager() {

    students = StudentSerializer.getStudents("StudentDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (students == null) {
        students = new ArrayList<Student>();
        }
}

public static void addStudent(Student newsStudent) {
    students.add(newsStudent);
    StudentSerializer.saveStudents(students, "StudentDatabase.ser");
    //System.out.println("Students Successfully Saved.");
}
public static ArrayList<Student> getStudents(){
    return students;
}
public static void updateStudents(Student student){
    int i=0;
    for (i=0;i<getStudents().size();i++)
                    {
                        if (student.getName().equals(getStudents().get(i).getName()))
                        {
                            getStudents().set(i,student);
                        }
                    }
                    StudentSerializer.saveStudents(getStudents(), "StudentDatabase.ser");
}
public static void clearStudents() {
    // Clear the student list
    StudentManager.students.clear();
    // Save the empty list to the serialized file
    StudentSerializer.saveStudents(students, "StudentDatabase.ser");
    //System.out.println("Student Database Cleared.");
}
} 