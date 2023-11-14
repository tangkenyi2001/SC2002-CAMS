import java.util.*;

public class StaffMenu {
    public static void printMenu(Staff aStaff, ArrayList<Camp> campList){
        Scanner sc = new Scanner(System.in);
        int choice;
        int i;
        do{
            System.out.println("(1) Create Camp");
            System.out.println("(2) View All Camps");
            System.out.println("(3) View Created Camps");
            System.out.println("(4) Edit Camp");
            System.out.println("(5) Delete Camp");
            System.out.println("(6) Change password");
            System.out.println("(7) Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    CampModifier.createCamp(aStaff);
                    break;

                case 2:
                    ViewHandler.viewAll();
                    break;

                case 3:
                    aStaff.viewCreatedCamps();
                    StaffCreated.printMenu();                    
                    break;
                    
                case 4:
                    System.out.println("Which camp would you like to edit?");
                    aStaff.viewCreatedCamps();
                    i = sc.nextInt()-1;
                    CampModifier.editCamp(aStaff,i);
                    break;

                case 5:
                    System.out.println("Which camp would you like to delete?");
                    aStaff.viewCreatedCamps();
                    i = sc.nextInt()-1;
                    CampModifier.deleteCamp(aStaff,i);
                    break;

                case 6: 
                    PasswordHandler.changePassword(aStaff);
                    break;
            }
        } while(choice < 7 && choice>0);
    }
}