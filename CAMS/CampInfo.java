import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*; 

public class CampInfo {
	private String campName;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate registrationDeadline;
	private String userGroup;
	private int totalSlots;
	private int campCommitteeSlots;
	private String description;
	private String staffInCharge;

    public CampInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Enter Camp Name: ");
            this.campName=(scanner.next());

        System.out.println("Enter Start Date (dd/mm/yyyy): ");
            String startDateStr = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.startDate = LocalDate.parse(startDateStr, formatter);
            System.out.println(this.startDate);   


        System.out.println("2.Enter End Date (dd/mm/yyyy): ");
            String endDateStr = scanner.next();
            this.endDate = LocalDate.parse(endDateStr, formatter);  
            System.out.println(this.endDate);  


        System.out.println("3.Enter Camp Registration Closing Date (dd/mm/yyyy): ");
            String RegCloseDateStr = scanner.next();
            DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.registrationDeadline= LocalDate.parse(RegCloseDateStr, formatter);  
            System.out.println(this.registrationDeadline); 
            



        System.out.println("4.Enter UserGroups allowed to join: ");
            this.userGroup=new UserGroup();





        System.out.println("5.Enter Location: ");
            this.location=new Location(scanner.next());

            System.out.println("6.Enter Total Slots: ");
            this.totalSlots=new TotalSlots(scanner.nextInt());
            this.campCommitteeSlots=new CampCommitteeSlots(totalSlots);
        System.out.println("8.Enter Description ");
            this.description=new Description(scanner.next());
        //System.out.println("9. Enter StaffInCharge ");
            //this.staffInCharge=new Description(scanner.next());
        System.out.println("Camp Created!");
        
    }
    public void get(){
        System.out.println("1. Camp Name: ");
        System.out.println(campName.getcampname());
        System.out.println("2. Camp Dates: ");
        System.out.println(dates.getdates());
        System.out.println("3. Camp Registration Closing Date: ");
        System.out.println(registrationClosingDate.getdates());
        System.out.println("4. UserGroups allowed to join: ");
        System.out.println(userGroup.getschool());
        System.out.println("5. Location: ");
        System.out.println(location.getLocation());
        System.out.println("6. Total Slots: ");
        System.out.println(totalSlots.gettotalSlots());
        System.out.println("7. Maximum Committee Slots: ");
        System.out.println(campCommitteeSlots.getCampCommitteeSlotCount());
        System.out.println("8. Description: ");
        System.out.println(description.getDescription());
        System.out.println("9. Staff In Charge: ");

    }
    public TotalSlots getTotalSlots(){
        return this.totalSlots;
    }
    
        
    

}