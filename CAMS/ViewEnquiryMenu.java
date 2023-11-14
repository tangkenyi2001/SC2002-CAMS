import java.util.ArrayList;
import java.util.Scanner;

public class ViewEnquiryMenu {
    public static void menu(Student student, ArrayList<Camp> campList){
        EnquiryHandler.view(student);
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("(1) Edit enquiry");
            System.out.println("(2) Delete enquiry");
            System.out.println("(3) Exit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    //EnquiryHandler.editEnquiry
                    break;
                case 2:
                    EnquiryHandler.view(student);
                    System.out.println("Choose enquiry to delete: ");
                    choice = sc.nextInt();
                    //EnquiryHandler.returnEnquiry(choice-1);
                    break;
                default:
                    break;
            }
        }while(choice < 3);
    }
}
