package Controller;

public class LogoutHandler {
    public static void logout(){
        System.out.println("You have logged out successfully. ");
        LoginHandler.login();
    }
}
