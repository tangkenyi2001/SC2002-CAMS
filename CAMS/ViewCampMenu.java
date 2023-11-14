import java.util.*;

public class ViewCampMenu{
    public static void menu(Student student, ArrayList<Camp> campList){
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            //Print list of camps open to student, maybe need PrintCampList class
            System.out.println("(1) View remaining slots of each camp");
            System.out.println("(2) Register for camp");
            System.out.println("(3) Submit enquiry for camp");
            System.out.println("(4) Exit");
            choice = sc.nextInt();
            Camp camp;
            switch(choice){
                case 1:
                    ViewHandler.viewAvailableSlots(student);
                    break;
                case 2:
                    ArrayList<Camp> availableCamps2 = ViewHandler.viewRegisterAvailable(student);
                    System.out.println("Select camp to register for: ");
                    choice = sc.nextInt();
                    camp = availableCamps2.get(choice -1);
                    RegistrationHandler.registerCamp(student, camp);
                    System.out.println("Registered for camp " + camp.getCampInfo().getCampName() + ".");
                    break;
                case 3:
                    ArrayList<Camp> enquiryCamps = ViewHandler.viewEnquiryAvailable(student);
                    System.out.println("Select camp to submit enquiry for: ");
                    choice = sc.nextInt();
                    camp = enquiryCamps.get(choice - 1);
                    System.out.println("Enter Enquiry: ");
                    String content = sc.next();
                    EnquiryHandler.submitEnquiry(student, content, camp);
                    System.out.println("Enquiry submitted for camp " + camp.getCampInfo().getCampName() + ".");
                    break;
                default:
                    break;
            }
        }while(choice<4);
    }
}
