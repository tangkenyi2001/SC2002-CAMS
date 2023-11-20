package Controller;

import java.util.Scanner;

import Boundary.CampCommitteeMenu;
import Boundary.StaffMenu;
import Boundary.StudentMenu;
import Manager.CampManager;
import Manager.StaffManager;
import Manager.StudentManager;
import Serializer.StaffSerializer;
import Serializer.StudentSerializer;
import Entity.*;

public class LoginHandler {
    public static void login(){
        String username,password,domain;
        Scanner sc =new Scanner(System.in);
        System.out.println("CAMS APPLICATION 2023 ");
        System.out.println("User Name: ");
        System.out.println("Password: ");
        System.out.println("Domain: ");
        System.out.println("Enter User Name: ");
        username=sc.nextLine().toUpperCase();
        System.out.println("Enter Password: ");
        password=sc.nextLine().toUpperCase();
        System.out.println("Enter Domain: ");
        domain=sc.nextLine().toUpperCase();
        //int status=VerificationHandler.verify(username, password, domain);
        User user=VerificationHandler.verify(username, password, domain);
         //-1 is non user
        //0 is student
        //1 is cc
        //2 is staff
        CampManager campManager=new CampManager();
        StudentManager studentmanager=new StudentManager();
        StaffManager staffmanager = new StaffManager();

        int i=0;
        if (user==(null))
        {
            
            LoginHandler.login();
        }
        
        else{
            if (password.toUpperCase().equals("PASSWORD")){
            do{
            
                PasswordHandler.changePassword(user);
                if (user instanceof Student)
                {
                    studentmanager.updateStudents((Student)user);
                }
                else{
                    staffmanager.updateStaff((Staff)user);
                }
                password=user.getPassword();
            }while (password.toUpperCase().equals("PASSWORD"));
            }
            i=0;
            if (user instanceof Student)
            {
                Student s=(Student)user;
                if (s.isCommitee()){
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
                else{
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
                
            }
            
            if (user instanceof Staff)
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
        