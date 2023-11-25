package Controller;

import java.io.IOException;

import Boundary.mainMenu;

public class LogoutHandler {
    public static void logout() throws IOException{
        System.out.println("You have logged out successfully. ");
        mainMenu.printMainMenu();
    }
}
