import java.util.*;
public class ViewRegisteredMenu {
    public static void menu(Student student, ArrayList<Camp> campList){
        Scanner sc = new Scanner(System.in);
        int choice;
        student.viewRegistered();
        do{
            System.out.println("(1) Withdraw from camp");
            System.out.println("(2) Exit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    //Adjust if camp committee camp included into registeredCamps
                    RegistrationHandler.withdrawCamp(student);
                    break;
                default:
                    break;
            }
        }while(choice < 2);
    }
}
