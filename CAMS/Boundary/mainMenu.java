package Boundary;

import java.util.*;

import Entity.Camp;
import Entity.Staff;
import Entity.Student;
public interface mainMenu {
	public void printMenu(Student student, ArrayList<Camp> campList);
	public void printMenu(Staff aStaff, ArrayList<Camp> campList); 
}