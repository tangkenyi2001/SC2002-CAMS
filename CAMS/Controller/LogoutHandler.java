package Controller;

import Boundary.mainMenu;

public class LogoutHandler {
    public static void logout(){
        System.out.println("You have logged out successfully. ");
        mainMenu.printMainMenu();
    }
}
