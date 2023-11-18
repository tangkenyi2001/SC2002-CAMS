package Manager;

import java.util.*; 
import java.io.*; 
import java.util.ArrayList;
import Controller.*; 


import Serializer.*; 

public class StudentManager {
    private ArrayList<Student> students ;
    static StudentSerializer s = new StudentSerializer();


public StudentManager() {

    students = StudentSerializer.getStudents("StudentDatabase.ser"); // not sure if it should be CampSerializer here or s (TBC) // 
    if (students == null) {
        students = new ArrayList<Student>();
        }
}

public void addStudent(Student newsStudent) {
    students.add(newsStudent);
    StudentSerializer.saveStudents(students, "StudentDatabase.ser");
    System.out.println("Students Successfully Saved.");
}

} 