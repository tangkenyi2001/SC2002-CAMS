package Controller;
import java.util.Scanner;

import Entity.User;

public class PasswordHandler {

    public static void changePassword(User aUser){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your old password:");
        String oldPW = sc.nextLine();
        if (oldPW.equals(aUser.getPassword())){
            System.out.println("Enter your new password");
            String newPW = sc.nextLine();
            aUser.setPassword(newPW);
            System.out.println("Password has been succesfully changed.");
        }
        else { 
            System.out.println("Password is wrong!");
        }
    }

}
