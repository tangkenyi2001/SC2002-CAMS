package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*; 
import Entity.*;

import Serializer.*; 
/**
 * Represents a StudentManager.
 * 
 * @author Etienne Borner
 * @version 1.0
 * @since 2023-11-26
 */
public class StudentManager {
/**
* Creates a ArrayList of students.
*/
    private static ArrayList<Student> students ;
    static StudentSerializer s = new StudentSerializer();

/**
* Creates a new StudentManager.
*/
public StudentManager() {

    students = StudentSerializer.getStudents("StudentDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (students == null) {
        students = new ArrayList<Student>();
        }
}

/**
* Add a new student to the ArrayList of students.
* Saves this ArrayList to the StudentDatabase serialized file.
*/
public static void addStudent(Student newsStudent) {
    students.add(newsStudent);
    StudentSerializer.saveStudents(students, "StudentDatabase.ser");
}

/**
* gets the ArrayList of students
* @return returns the ArrayList of students
*/
public static ArrayList<Student> getStudents(){
    return students;
}

/**
* update changes made to a student.
* @param student to be updated.
*/
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

/**
* gets the ArrayList of students
* saves the empty ArrayList of students back to StudentDatabase serialized file.
*/
public static void clearStudents() {
    StudentManager.students.clear();
    StudentSerializer.saveStudents(students, "StudentDatabase.ser");
}
} 
