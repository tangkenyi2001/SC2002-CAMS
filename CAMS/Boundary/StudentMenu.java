package Boundary;
import java.util.*;

import Controller.EnquiryHandler;
import Controller.PasswordHandler;
import Controller.RegistrationHandler;
import Controller.SuggestionHandler;
import Controller.ViewHandler;
import Entity.Camp;
import Entity.Enquiry;
import Entity.Student;

public class StudentMenu{
    public static void printMenu(Student student, ArrayList<Camp> campList){
        Scanner sc = new Scanner(System.in);
        int choice;
        Camp camp;
        if(student.isCommitee()){
            do{
                System.out.println("(1) View Camps");
                System.out.println("(2) View Registered Camps");
                System.out.println("(3) View Enquiries");
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
                        student.viewRegistered();
                        break;
                    case 3:
                        ViewHandler.viewEnquiries(student);
                        break;
                    case 4:
                        
                        ArrayList<Camp> availableCamps = ViewHandler.viewRegisterAvailable(student);
                        if (availableCamps.size()==0)
                        {
                            System.out.println("No available Camps");
                            break;
                        }
                        System.out.println("Select camp to register for: ");
                        choice = sc.nextInt();
                        camp = availableCamps.get(choice -1);
                        RegistrationHandler.registerCamp(student, camp);
                        System.out.println("Registered for camp " + camp.getCampInfo().getCampName() + ".");
                        break;
                    case 5:
                        ArrayList<Camp> enquiryCamps = ViewHandler.viewEnquiryAvailable(student);
                        System.out.println("Select camp to submit enquiry for: ");
                        choice = sc.nextInt();
                        camp = enquiryCamps.get(choice - 1);
                        System.out.println("Enter Enquiry: ");
                        String content = sc.next();
                        EnquiryHandler.submitEnquiry(student, content, camp);
                        System.out.println("Enquiry submitted for camp " + camp.getCampInfo().getCampName() + ".");
                        break;
                    case 6:
                        ViewHandler.viewEnquiries(student);
                        System.out.println("Select enquiry to delete: ");
                        choice = sc.nextInt();
                        Enquiry enquiryToDelete = student.getEnquiries().get((choice -1));
                        EnquiryHandler.deleteEnquiry(enquiryToDelete, student);
                        break;
                    case 7:
                        ViewHandler.viewEnquiries(student);
                        System.out.println("Select enquiry to edit: ");
                        choice = sc.nextInt();
                        Enquiry enquiryToEdit = student.getEnquiries().get((choice -1));
                        EnquiryHandler.editEnquiry(enquiryToEdit, student);
                        break;
                    case 8:
                        RegistrationHandler.withdrawCamp(student);
                        break;
                    case 9:
                        PasswordHandler.changePassword(student);
                        break;
                    case 10:
                        if(student.getCampCommittee() != null){
                            //Submit Suggestions
                        }else{
                            //Logout
                        }
                        break;
                    default:
                        break;
                }
            }while(choice < 11);
        }
        else{
            do{
                System.out.println("(1) View Camps");
                System.out.println("(2) View Registered Camps");
                System.out.println("(3) View Enquiries");
                System.out.println("(4) Register for Camps");
                System.out.println("(5) Submit Enquiry for Camp");
                System.out.println("(6) Delete Enquiry for Camp");
                System.out.println("(7) Edit Enquiry for Camp");
                System.out.println("(8) Withdraw from Camp"); 
                System.out.println("(9) Change Password");
                System.out.println("(10) Submit Suggestions");
                System.out.println("(11) View Suggestions");
                System.out.println("(12) Edit Suggestion");
                System.out.println("(13) Delete Suggestion");
                System.out.println("(14) View Camp Enquiries");
                System.out.println("(15) Reply Camp Enquiries");
                System.out.println("(16) Logout");      
                System.out.println("Enter choice: ");
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        ViewHandler.viewAvailableSlots(student);
                        break;
                    case 2:
                        student.viewRegistered();
                        break;
                    case 3:
                        ViewHandler.viewEnquiries(student);
                        break;
                    case 4:
                        ArrayList<Camp> availableCamps = ViewHandler.viewRegisterAvailable(student);
                        System.out.println("Select camp to register for: ");
                        choice = sc.nextInt();
                        camp = availableCamps.get(choice -1);
                        RegistrationHandler.registerCamp(student, camp);
                        System.out.println("Registered for camp " + camp.getCampInfo().getCampName() + ".");
                        break;
                    case 5:
                        ArrayList<Camp> enquiryCamps = ViewHandler.viewEnquiryAvailable(student);
                        System.out.println("Select camp to submit enquiry for: ");
                        choice = sc.nextInt();
                        camp = enquiryCamps.get(choice - 1);
                        System.out.println("Enter Enquiry: ");
                        String content = sc.next();
                        EnquiryHandler.submitEnquiry(student, content, camp);
                        System.out.println("Enquiry submitted for camp " + camp.getCampInfo().getCampName() + ".");
                        break;
                    case 6:
                        ViewHandler.viewEnquiries(student);
                        System.out.println("Select enquiry to delete: ");
                        choice = sc.nextInt();
                        Enquiry enquiryToDelete = student.getEnquiries().get((choice -1));
                        EnquiryHandler.deleteEnquiry(enquiryToDelete, student);
                        break;
                    case 7:
                        ViewHandler.viewEnquiries(student);
                        System.out.println("Select enquiry to edit: ");
                        choice = sc.nextInt();
                        Enquiry enquiryToEdit = student.getEnquiries().get((choice -1));
                        EnquiryHandler.editEnquiry(enquiryToEdit, student);
                        break;
                    case 8:
                        RegistrationHandler.withdrawCamp(student);
                        break;
                    case 9:
                        PasswordHandler.changePassword(student);
                        break;
                    case 10:
                        break;
                    case 11:
                        SuggestionHandler.viewSuggestion(student);
                        break;
                    case 12:
                        SuggestionHandler.editSuggestion(student);
                        break;
                    case 13:
                        //Delete Suggestions
                        SuggestionHandler.deleteSuggestion(student);
                        break;
                    case 14:
                        Camp inChargeOf = student.getCampCommittee().getCommitteeOf();
                        ViewHandler.viewEnquiries(inChargeOf);
                        break;
                    case 15:
                        Camp inChargeOf2 = student.getCampCommittee().getCommitteeOf();
                        ViewHandler.viewEnquiries(inChargeOf2);
                        System.out.println("Select enquiry to reply: ");
                        choice = sc.nextInt();
                        Enquiry toReply = inChargeOf2.getEnquiries().get(choice-1);
                        EnquiryHandler.replyEnquiry(toReply);
                        break;
                    case 16:
                        //Logout
                        break;
                    default:
                        break;
                }
            }while(choice < 17);
        }
    }
}
