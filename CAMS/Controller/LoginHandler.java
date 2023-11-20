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
        String username,password;
        int domain;
        Scanner sc =new Scanner(System.in);
        System.out.println("CAMS APPLICATION 2023 ");
        do{
            do{
                System.out.println("Enter Domain: ");
                System.out.println("(1) Student ");
                System.out.println("(2) Staff ");
                domain=sc.nextInt();
                sc.nextLine();
            }while (domain!=1&&domain!=2);
        System.out.println("Enter User Name: ");
        username=sc.nextLine().toUpperCase();
        }while (!VerificationHandler.verifyUser(username, domain));
        
        System.out.println("Enter Password: ");
        password=sc.nextLine();        
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
            if (password.equals("password")){
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
            }while (password.equals("password"));
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
        