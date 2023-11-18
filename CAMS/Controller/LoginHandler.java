package Controller;

import java.util.Scanner;

import Boundary.CampCommitteeMenu;
import Boundary.StaffMenu;
import Boundary.StudentMenu;
import Manager.CampManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Entity.*;

public class LoginHandler {
    public static void login(){
        String username,password,domain;
        Scanner sc =new Scanner(System.in);
        System.out.println("User Name: ");
        System.out.println("Password: ");
        System.out.println("Domain: ");
        System.out.println("Enter User Name: ");
        username=sc.nextLine();
        System.out.println("Enter Password: ");
        password=sc.nextLine();
        System.out.println("Enter Domain: ");
        domain=sc.nextLine();
        int status=VerificationHandler.verify(username, password, domain);
         //-1 is non user
        //0 is student
        //1 is cc
        //2 is staff
        CampManager campManager=new CampManager();
        StudentManager studentmanager=new StudentManager();
        StaffManager staffmanager = new StaffManager();
        
        int i=0;
        if (status==-1)
        {
            System.out.println("No Existing User! ");
            System.out.println("Please Try Again! ");
            LoginHandler.login();
        }
        else{
            if (status==0)
            {
                Student student=studentmanager.getStudents().get(i);
                for (i=0;i<studentmanager.getStudents().size();i++)
                {
                    if (username.equals(studentmanager.getStudents().get(i).getName())){
                        student=studentmanager.getStudents().get(i);
                        break;
                    }
                }

                StudentMenu.printMenu(student,campManager.getCamp());
            }
            if (status==1)
            {
                Student campcommittee=studentmanager.getStudents().get(i);
                for (i=0;i<studentmanager.getStudents().size();i++)
                {
                    if (username.equals(studentmanager.getStudents().get(i).getName())){
                        campcommittee=studentmanager.getStudents().get(i);
                        break;
                    }
                }
                CampCommitteeMenu.printMenu(campcommittee, campManager.getCamp());
            }
            if (status==2)
            {
                Staff staff=staffmanager.getStaff().get(i);
                for (i=0;i<staffmanager.getStaff().size();i++)
                {
                    if (username.equals(staffmanager.getStaff().get(i).getName())){
                        staff=staffmanager.getStaff().get(i);
                        break;
                    }
                }
                StaffMenu.printMenu(staff, campManager.getCamp());
            }
        }

    }
}
        