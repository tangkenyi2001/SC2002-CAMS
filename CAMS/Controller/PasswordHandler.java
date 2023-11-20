package Controller;

import java.util.Scanner;

import Entity.Student;
import Entity.User;
import Serializer.StudentSerializer;

public class PasswordHandler {

    public static void changePassword(User aUser) {
        Scanner sc = new Scanner(System.in);
         System.out.println("Change the default password: ");
        System.out.print("Enter your old password: ");
        String oldPW = sc.nextLine();        
        if (verifyOldPassword(aUser, oldPW)) {
            String newPW;
            do {
                System.out.print("Enter your new password: ");
                newPW = sc.nextLine();
        
                if (newPW.equalsIgnoreCase("PASSWORD")) {
                    System.out.println("New Password cannot be the default password.");
                } else {
                    aUser.setPassword(newPW);
                    System.out.println("Password has been successfully changed.");
                }
            } while (newPW.equalsIgnoreCase("password"));
            
        } else {
            System.out.println("Incorrect old password!");
        }
    }

    private static boolean verifyOldPassword(User aUser, String oldPassword) {
        return aUser.getPassword().equals(oldPassword);
    }
}
