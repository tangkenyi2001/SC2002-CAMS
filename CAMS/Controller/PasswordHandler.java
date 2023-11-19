package Controller;

import java.util.Scanner;

import Entity.User;

public class PasswordHandler {

    public static void changePassword(User aUser) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your old password: ");
        String oldPW = sc.nextLine();        
        if (verifyOldPassword(aUser, oldPW)) {
            System.out.print("Enter your new password: ");
            String newPW = sc.nextLine();
            aUser.setPassword(newPW);
            System.out.println("Password has been successfully changed.");
        } else {
            System.out.println("Incorrect old password!");
        }
    }

    private static boolean verifyOldPassword(User aUser, String oldPassword) {
        return aUser.getPassword().equals(oldPassword);
    }
}
