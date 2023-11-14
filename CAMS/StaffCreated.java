import java.util.Scanner;

public class StaffCreated {
    public static void printMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("(1) View Suggestions");
            System.out.println("(2) View Enquiries");
            System.out.println("(3) Back");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    
                    break;
           
                case 2:
                   
                    break;

                case 3:

                    
                    break;
            }
        }while(choice < 5 && choice>0);
    }
}
