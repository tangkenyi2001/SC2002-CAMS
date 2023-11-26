package Controller;

import Entity.User;
import Manager.StaffManager;
import Manager.StudentManager;
/**
 * Takes care of verification of user input ID and password
 * Returns respective user if verified
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class VerificationHandler {
    /**
     * Verifies user input ID to check if user exists
     * @param username User input ID
     * @param domain Integer representing type of user
     * @return
     */
    public static boolean verifyUser(String username,int domain){
        if (domain==1)
        {
            StudentManager student =new StudentManager();
            //gets the array list of students
            int i=0;

            for (i=0;i<student.getStudents().size();i++)
                {
                if (username.equals(student.getStudents().get(i).getId())){
                    break;
                }
                }
                if (i==student.getStudents().size()){
                    System.out.println("No Existing Student! ");
                    System.out.println("Please Try Again! ");
                    return false;
                }
                return true;
            }
        if (domain==2)
        {
            StaffManager staff =new StaffManager();
            //gets the arraty list of staffs
            int i=0;
            for (i=0;i<staff.getStaff().size();i++)
            {
                if (username.equals(staff.getStaff().get(i).getId())){
                 break;
                }
                }
                if (i==staff.getStaff().size()){
                    System.out.println("No Existing Staff! ");
                    System.out.println("Please Try Again! ");
                    return false;
                }
                return true;
        }
        return false;
    }
    /**
     * Verifies password of user of ID
     * @param username User input ID
     * @param password User input password
     * @param domain Integer representing type of user
     * @return User of respective ID and password
     */
    public static User verify(String username,String password, int domain){
        //-1 is non user
        //0 is student
        //1 is cc
        //2 is staff

        if (domain==1)
        {
            StudentManager student =new StudentManager();
            //gets the arraty list of students
            int i=0;
            for (i=0;i<student.getStudents().size();i++)
            {
                if (username.equals(student.getStudents().get(i).getId())){
                    if (password.equals(student.getStudents().get(i).getPassword()))
                    {
                        if (student.getStudents().get(i).isCommittee()==true)
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
        if (domain==2)
        {
            StaffManager staff =new StaffManager();
            //gets the array list of staffs
            int i=0;
            for (i=0;i<staff.getStaff().size();i++)
            {
                if (username.equals(staff.getStaff().get(i).getId())){
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
