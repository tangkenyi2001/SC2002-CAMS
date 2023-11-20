package Controller;

import Entity.User;
import Manager.StaffManager;
import Manager.StudentManager;
// call this to check if item is in database
public class VerificationHandler {
    public static User verify(String username,String password, String domain){
        //-1 is non user
        //0 is student
        //1 is cc
        //2 is staff

        if (domain.toUpperCase().equals("STUDENT"))
        {
            StudentManager student =new StudentManager();
            //gets the arraty list of students
            int i=0;
            for (i=0;i<student.getStudents().size();i++)
            {
                if (username.equals(student.getStudents().get(i).getName())){
                    if (password.equals(student.getStudents().get(i).getPassword()))
                    {
                        if (student.getStudents().get(i).isCommitee()==true)
                        {
                            return student.getStudents().get(i);
                            
                        }
                        
                        else{
                            return student.getStudents().get(i);
                        }
                    }
                    else{
                        System.out.println("Wrong Password! ");
                        System.out.println("Please Try Again! ");
                        return null;
                    }
                }
            }
            System.out.println("No Existing Student! ");
            System.out.println("Please Try Again! ");

        }
        if (domain.toUpperCase().equals("STAFF"))
        {
            StaffManager staff =new StaffManager();
            //gets the arraty list of staffs
            int i=0;
            for (i=0;i<staff.getStaff().size();i++)
            {
                if (username.equals(staff.getStaff().get(i).getName())){
                    if (password.equals(staff.getStaff().get(i).getPassword()))
                    {
                        return staff.getStaff().get(i);
                    }
                    else{
                        System.out.println("Wrong Password! ");
                        System.out.println("Please Try Again! ");
                        return null;
                    }
                }
            }
            System.out.println("No Existing Staff! ");
            System.out.println("Please Try Again! ");
        }
        System.out.println("No Existing User! ");
        System.out.println("Please Try Again! ");
        return null;
    }
}
