package Controller;

import java.io.IOException;
import Boundary.mainMenu;
/**
 * Handles log out function
 * @author Randall Chiang Tian Cong
 * @version 1.0
 * @since 2023-11-26
 */
public class LogoutHandler {
    /**
     * Logs out and goes back to main menu
     * @throws IOException
     */
    public static void logout() throws IOException{
        System.out.println("You have logged out successfully. ");
        mainMenu.printMainMenu();
    }
}
