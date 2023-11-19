package Controller;

import java.util.Scanner;

public class Beauty {
    static Scanner sc = new Scanner(System.in);

    public static void returnMenu(){
        backFunction();
        mainMenu();
    }

    public static void backFunction(){
        System.out.println("Press <key> to return");
        sc.next();
        return;
    }

    public static void mainMenu(){
            String decoratedString = "╔════════════════════════╗\n"
                                   + "║        " + "Main Menu" + "       ║\n"
                                   + "╚════════════════════════╝";
            System.out.println(decoratedString);
    }

}


