import java.util.*;
public class StudentMenu implements mainMenu {
    public void printMenu(Student student, ArrayList<Camp> campList){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("(1) View Camps");
            System.out.println("(2) View Registered Camps");
            System.out.println("(3) View Enquiries");
            System.out.println("(4) Change password");
            System.out.println("(5) Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    ViewCampMenu.menu(student, campList);
                    break;
                case 2:
                    ViewRegisteredMenu.menu(student, campList);
                    break;
                case 3:
                    ViewEnquiryMenu.menu(student, campList);
                    //change password
                    break;
                default:
                    break;
            }
        }while(choice < 3);
    }
}
