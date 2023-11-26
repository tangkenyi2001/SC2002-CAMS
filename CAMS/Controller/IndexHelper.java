package Controller;

import java.util.Scanner;
/**
 * IndexHelper class provides methods to select a camp
 * It allows users to choose a camp via index.
 *  @author Tang Ken Yi
 *  @version 1.0
 *  @since 2023-11-26
 */
public class IndexHelper {
    /**
     * Allow the user to choose which camp he wants via index
     * @return The index of the selected camp.
     */
     public static int indexOfCamp() {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the camp you would like to view:");
        choice = sc.nextInt();
        return choice-1;
    }
}
