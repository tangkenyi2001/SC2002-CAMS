package Boundary;

import java.util.*;

import Controller.Beauty;
import Controller.CampModifier;
import Controller.ClearDatabase;
import Controller.IntialiseHandler;
import Controller.LoginHandler;
import Controller.StaffViewHandler;
import Entity.Camp;
import Entity.Staff;
import Entity.Student;
public class mainMenu {

public static void printMainMenu(){
        Scanner sc= new Scanner(System.in);
        int choice;
        int i;
         do{
            Beauty.mainMenu();
            System.out.println("(1) Login");
            System.out.println("(2) Intialise Database");
            System.out.println("(3) Clear Database");
            System.out.println("(4) Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    LoginHandler.login();
                    break;

                case 2:
                    IntialiseHandler.loaddata(); 
                    break;

                case 3:
                    ClearDatabase.clearAll();
                    System.out.println("Database has been cleared");                  
                    break;
                    
                case 4:
                    System.out.println("Exiting Program");
                    System.exit(0);
                    break;
                } if (choice != 4) Beauty.backFunction();
                }while(choice < 4 && choice>0);
        }            
public static void returnMenu(){
	Scanner sc=new Scanner(System.in);
	System.out.println("Password is wrong!\nPress <key> to return");
        sc.next();
        return;
}
}