package Controller;

import java.util.Scanner;
import java.io.IOException; 


public class Beauty {
    static Scanner sc = new Scanner(System.in);

    public static void returnMenu(){
        backFunction();
        mainMenu();
    }

    public static void backFunction(){
        System.out.println("Press <key> to return");
        sc.next();
 
    }
    


    public static void mainMenu(){
            String decoratedString = "╔════════════════════════╗\n"
                                   + "║        " + "Main Menu" + "       ║\n"
                                   + "╚════════════════════════╝";
            System.out.println(decoratedString);
    }

}


