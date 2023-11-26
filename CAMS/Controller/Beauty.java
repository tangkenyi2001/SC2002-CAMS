package Controller;

import java.util.Scanner;
import java.io.IOException;
/**
 * The Beauty class makes the console output look livelier.
 * It includes methods for displaying menus for different users,and allowing users to go back.
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */
public class Beauty {
    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";
    public static Scanner sc = new Scanner(System.in);
    /**
     * Waits for user input before return to the main menu.
     */
    public static void returnMenu(){
        backFunction();
        mainMenu();
    }
    /**
     * Displays a message and waits for user input to continue.
     */
    public static void backFunction(){
        System.out.println("Press <key> to return");
        sc.next();
    }
    /**
     * Displays the main menu header.
     */
    public static void mainMenu(){
        String decoratedString = "+-----------------------+\n"
                               + "|       Main Menu       |\n"
                               + "+-----------------------+";
        System.out.println(decoratedString);
        System.out.println("Welcome to CAMS!\n" + "--------------");
    }
    /**
     * Displays the staff menu header.
     */
    public static void StaffMenu(){
        String decoratedString = "+-----------------------+\n"
                               + "|       Staff Menu      |\n"
                               + "+-----------------------+";
        System.out.println(decoratedString);
    }
    /**
     * Displays the committee menu header.
     */
    public static void CCMenu(){
        String decoratedString = "+-----------------------+\n"
                               + "|  Committee Menu       |\n"
                               + "+-----------------------+";
        System.out.println(decoratedString);
    }
    /**
     * Displays the student menu header.
     */
    public static void StudentMenu(){
        String decoratedString = "+-----------------------+\n"
                               + "|    Student Menu       |\n"
                               + "+-----------------------+";
        System.out.println(decoratedString);
    }
}
