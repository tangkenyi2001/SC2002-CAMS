package Boundary;
import java.io.IOException;
import java.util.*;

import Controller.Beauty;
import Controller.CampCommitteeEnquiryHandler;
import Controller.EnquiryHandler;
import Controller.GenerateHandler;
import Controller.LogoutHandler;
import Controller.PasswordHandler;
import Controller.RegistrationHandler;
import Controller.StaffEnquiryHandler;
import Controller.SuggestionHandler;
import Controller.ViewHandler;
import Entity.Camp;
import Entity.Enquiry;
import Entity.Student;

public class StudentMenu{
    public static void printMenu(Student student, ArrayList<Camp> campList) throws IOException{
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        Camp camp;
        do{     
            if(!student.isCommittee()){
                System.out.println(Beauty.YELLOW);
                Beauty.StudentMenu();
                System.out.println("(1) View Available Camps");
                System.out.println("(2) View Registered Camps");
                System.out.println("(3) View Submitted Enquiries");
                System.out.println("(4) Register for Camps");
                System.out.println("(5) Submit Enquiry for Camp");
                System.out.println("(6) Delete Enquiry for Camp");
                System.out.println("(7) Edit Enquiry for Camp");
                System.out.println("(8) Withdraw from Camp"); 
                System.out.println("(9) Change Password");
                System.out.println("(10) Logout");       
                System.out.println("Enter choice: ");
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        ViewHandler.viewAvailableSlots(student);
                        break;
                    case 2:
                        student.viewRegistered(student);
                        break;
                    case 3:
                        ViewHandler.viewEnquiries(student);
                        break;
                    case 4:
                        RegistrationHandler.registerCamp(student);
                        break;
                    case 5:
                        EnquiryHandler.submitEnquiry(student);
                        break;
                    case 6:
                        EnquiryHandler.deleteEnquiry(student);
                        break;
                    case 7:
                        EnquiryHandler.editEnquiry(student);
                        break;
                    case 8:
                        RegistrationHandler.withdrawCamp(student);
                        break;
                    case 9:
                        PasswordHandler.changePassword(student);
                        break;
                    case 10:
                        System.out.println(Beauty.RESET);
                        LogoutHandler.logout();
                        break;
                    default:
                        break;
                }Beauty.backFunction();
            }
        else if(student.isCommittee()){
            System.out.println(Beauty.GREEN);
            //Beauty.CCMenu();
            System.out.println("(1) View Available Camps");
            System.out.println("(2) View Registered Camps");
            System.out.println("(3) View Submitted Enquiries");
            System.out.println("(4) Register for Camps");
            System.out.println("(5) Submit Enquiry for Camp");
            System.out.println("(6) Delete Enquiry for Camp");
            System.out.println("(7) Edit Enquiry for Camp");
            System.out.println("(8) Withdraw from Camp"); 
            System.out.println("(9) Change Password");
            System.out.println("(10) Logout");      
            System.out.println("---------------------------\n"
                            +  "    Committee Exclusive    \n"
                            +  "---------------------------");
            System.out.println("(11) Submit Suggestions");
            System.out.println("(12) View Suggestions");
            System.out.println("(13) Edit Suggestion");
            System.out.println("(14) Delete Suggestion");
            System.out.println("(15) View Camp Enquiries");
            System.out.println("(16) Generate Report");
            
            System.out.println("Enter choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    ViewHandler.viewAvailableSlots(student);
                    break;
                case 2:
                    student.viewRegistered(student);
                    break;
                case 3:
                    ViewHandler.viewEnquiries(student);
                    break;
                case 4:
                    RegistrationHandler.registerCamp(student);
                    break;
                case 5:
                    EnquiryHandler.submitEnquiry(student);
                    break;
                case 6:
                    EnquiryHandler.deleteEnquiry(student);
                    break;
                case 7:
                    EnquiryHandler.editEnquiry(student);
                    break;
                case 8:
                    RegistrationHandler.withdrawCamp(student);
                    break;
                case 9:
                    PasswordHandler.changePassword(student);
                    break;
                case 10:
                    System.out.println(Beauty.RESET);
                    LogoutHandler.logout();
                    break;
                case 11:
                    SuggestionHandler.submitSuggestions(student);
                    break;
                case 12:
                    SuggestionHandler.viewSuggestion(student);
                    break;
                case 13:
                    SuggestionHandler.editSuggestion(student);
                    break;
                case 14:
                    SuggestionHandler.deleteSuggestion(student);
                    break;
                case 15:
                    CampCommitteeEnquiryHandler.view(student);
                    break;
                case 16:
                    GenerateHandler.generateReport(student.getCampCommittee().getCommitteeOf());
                    break;

                }Beauty.backFunction();
            }
        }while(choice < 17 && choice > 0);
    }
}
