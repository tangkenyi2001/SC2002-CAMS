import java.util.Scanner;

public class PasswordHandler {

    public static void changePassword(User aUser){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your old password:");
        String oldPW = sc.nextLine();
        if (oldPW == aUser.getPassword()){
            System.out.println("Enter your new password");
            String newPW = sc.nextLine();
            aUser.setPassword(newPW);
            System.out.println("Password has been succesfully changed.\nPress <key> to return");
        }
        else { 
            System.out.println("Password is wrong!\nPress <key> to return");
        }

        sc.next();
        return;
    }

}
