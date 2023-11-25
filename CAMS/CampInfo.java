import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
<<<<<<< Updated upstream:CAMS/CampInfo.java
import java.util.*; 
=======
import java.util.*;

import java.io.Serializable;
>>>>>>> Stashed changes:CAMS/Entity/CampInfo.java

public class CampInfo {
	private String campName;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate registrationDeadline;
	private String usergroup;
    private String location;
	private int totalSlots;
	private int campCommitteeSlots;
	private String description;
	private Staff staffInCharge;
	static Scanner scanner = new Scanner(System.in);
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

<<<<<<< Updated upstream:CAMS/CampInfo.java
    public CampInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Enter Camp Name: ");
            this.campName=(scanner.next().toUpperCase());

        System.out.println("2.Enter Start Date (dd/mm/yyyy): ");
            String startDateStr = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.startDate = LocalDate.parse(startDateStr, formatter);
            //System.out.println(this.startDate);   


        System.out.println("2.Enter End Date (dd/mm/yyyy): ");
            String endDateStr = scanner.next();
            this.endDate = LocalDate.parse(endDateStr, formatter);  
            //System.out.println(this.endDate);  


        System.out.println("3.Enter Camp Registration Closing Date (dd/mm/yyyy): ");
            String RegCloseDateStr = scanner.next();
            DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.registrationDeadline= LocalDate.parse(RegCloseDateStr, formatter);  
            System.out.println(this.registrationDeadline); 
            
        System.out.println("4.Enter UserGroups allowed to join: ");
        System.out.println("  Enter School or Enter ANY if open to whole NTU: ");
            this.userGroup= scanner.next().toUpperCase();


        System.out.println("5.Enter Location: ");
            this.location=scanner.next().toUpperCase();

        System.out.println("6.Enter Total Slots: ");
            this.totalSlots=scanner.nextInt();
        System.out.println("7 .Enter Number of Camp Committee Slots: ");   
            this.campCommitteeSlots=scanner.nextInt();
        System.out.println("8.Enter Description ");
            this.description=scanner.next().toUpperCase();
        System.out.println("9. Enter StaffInCharge ");
            this.staffInCharge=scanner.next().toUpperCase();
        System.out.println("Camp Created!");
        
    }
=======
    public CampInfo(Staff staff){
			//System.out.print("1. ");
			setCampName();
			//System.out.print("2. ");
			setStartDate();
			//System.out.print("   ");
			setEndDate();
			//System.out.print("3. ");
			setDeadline();
			//System.out.print("4. ");
			setUserGroup();
			//System.out.print("5. ");
			setLocation();
			//System.out.print("6. ");
			setTotalSlots();
			//System.out.print("7. ");
			setCommitteeSlots();
			//System.out.print("8. ");
			setDescription();
			this.staffInCharge=staff;
			System.out.println("Camp Created!");
			System.out.println("Default visibility is False!");
			System.out.println("Toggle visibility via edit Camps");
	}


>>>>>>> Stashed changes:CAMS/Entity/CampInfo.java
    public String getCampName() {
		return this.campName;
	}

	public void setCampName() {
<<<<<<< Updated upstream:CAMS/CampInfo.java
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Camp Name: ");
            this.campName=(scanner.next().toUpperCase());
=======
		//scanner.nextLine();
		System.out.println("Enter Camp Name: ");
        this.campName=(scanner.nextLine().toUpperCase());
>>>>>>> Stashed changes:CAMS/Entity/CampInfo.java
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}
	public LocalDate getEndDate() {
		return this.endDate;
	}
	public void setStartDate() {
<<<<<<< Updated upstream:CAMS/CampInfo.java
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Start Date (dd/mm/yyyy): ");
            String startDateStr = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.startDate = LocalDate.parse(startDateStr, formatter); 
	}
	public void setEndDate() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter End Date (dd/mm/yyyy): ");
            String endDateStr = scanner.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.endDate = LocalDate.parse(endDateStr, formatter);  
=======
			do {
				System.out.println("Enter Start Date (dd/mm/yyyy): ");
				String startDateStr = scanner.next();
	
				try {
					this.startDate = LocalDate.parse(startDateStr, formatter);
					if(startDate.isBefore(java.time.LocalDate.now())){
					System.out.println("Start Date cannot be before Current Date! Try again!"); 
						}
					//break; // Break the loop if parsing is successful
				} catch (Exception e) {
					System.out.println("Invalid date format. Please try again.");
				}
			} while( startDate.isBefore(java.time.LocalDate.now())); 
	}

	public void setEndDate() {
			do{
				System.out.println("Enter End Date (dd/MM/yyyy): ");
				String endDateStr = scanner.next();
	
				try {
					this.endDate = LocalDate.parse(endDateStr, formatter);
					if( endDate.isBefore(startDate) ){
					System.out.println("End Date cannot be before Start Date! Try again! "); 
				}
					//break; // Break the loop if parsing is successful
				} catch (Exception e) {
					System.out.println("Invalid date format. Please try again.");
				}
			} while ( endDate.isBefore(startDate) );
>>>>>>> Stashed changes:CAMS/Entity/CampInfo.java
	}

	public LocalDate getDeadline() {
		// TODO - implement campInformation.getDeadline
		return this.registrationDeadline;
	}

	public void setDeadline() {
<<<<<<< Updated upstream:CAMS/CampInfo.java
		// TODO - implement campInformation.setDeadline
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Camp Registration Closing Date (dd/mm/yyyy): ");
            String RegCloseDateStr = scanner.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.registrationDeadline= LocalDate.parse(RegCloseDateStr, formatter);  
=======
			// Validate and set Registration Deadline
			do {
				System.out.println("Enter Camp Registration Closing Date (dd/MM/yyyy): ");
				String regCloseDateStr = scanner.next();
	
				try {
					this.registrationDeadline = LocalDate.parse(regCloseDateStr, formatter);
					if((registrationDeadline.isAfter(startDate) || registrationDeadline.isEqual(startDate))){
						System.out.println("Registration Deadline must be before Start Date! Try Again!");
					}
					else if (registrationDeadline.isBefore(java.time.LocalDate.now())) System.out.println("Registration Deadline must be after today! Try Again!");
					//break; // Break the loop if parsing is successful
				} catch (Exception e) {
					System.out.println("Invalid date format. Please try again.");
				}
			} while(registrationDeadline.isAfter(startDate) || registrationDeadline.isEqual(startDate) || registrationDeadline.isBefore(java.time.LocalDate.now()));
>>>>>>> Stashed changes:CAMS/Entity/CampInfo.java
	}

	public int getTotalSlots() {
		return this.totalSlots;
	}

	public void setTotalSlots() {
		System.out.println("Enter Total Slots: ");
            this.totalSlots=scanner.nextInt();
	}
	public void minusSlot(){
		this.totalSlots--;
	}
	public void addSlot(){
		this.totalSlots++;
	}
	public void minusCommitteeSlots(){
		this.campCommitteeSlots--;
	}
	public int getCommitteeSlots() {
		return this.campCommitteeSlots;
	}

	public void setCommitteeSlots() {
		do{ 
        System.out.println("Enter Number of Camp Committee Slots: ");  
			try{
				this.campCommitteeSlots=scanner.nextInt();
			}
			catch(Exception e){
				System.out.println("Invalid format. Please try again.");
			}
            
			if(this.campCommitteeSlots>10){
				System.out.println("Camp Committee Slots must be less than 10");
			}
			if(this.totalSlots < this.campCommitteeSlots){
				System.out.println("Camp Committee Slots must be less than total slots");
			}
		} while(this.campCommitteeSlots>10 || this.totalSlots < this.campCommitteeSlots); 
			
	}

	public Staff getStaffIC() {
		return this.staffInCharge;
	}


	public int getAttendeeSlots() {
		return this.totalSlots-this.campCommitteeSlots;
	}

	

	public String getLocation() {
		return this.location;
	}
	
	public void setLocation() {
		scanner.nextLine();
		System.out.println("Enter Location: ");
		this.location=scanner.nextLine().toUpperCase();

	}

	public String getUserGroup() {
		return this.usergroup;
	}

	public void setUserGroup() {
			String userGroupStr;
			List<String> validUserGroups = Arrays.asList("SCSE", "NBS", "EEE", "ANY", "SSS", "ADM");
			do {
				System.out.println("Enter UserGroups allowed to join: ");
				System.out.println("Enter School or Enter ANY if open to whole NTU: ");
				userGroupStr = scanner.next().toUpperCase();
					this.usergroup = userGroupStr;

					if (!validUserGroups.contains(userGroupStr))System.out.println("Invalid UserGroup. Please enter a valid group or ANY.");
			}while(!validUserGroups.contains(userGroupStr));
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription() {
		scanner.nextLine();
		System.out.println("Enter Description ");
            this.description=scanner.nextLine().toUpperCase();
	}
}