package Controller;

import java.util.Scanner;

public class IndexHelper {

     public static int indexOfCamp() {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the camp you would like to view:");
        choice = sc.nextInt();
        return choice-1;
    }
}
