package Entity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*; 
import java.io.Serializable;

public class CampInfo implements Serializable{
	private String campName;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate registrationDeadline;
	private String userGroup;
    private String location;
	private int totalSlots;
	private int campCommitteeSlots;
	private String description;
	private String staffInCharge;

    public CampInfo(){
        	Scanner scanner = new Scanner(System.in);

        	System.out.println("1.Enter Camp Name: ");
            this.campName=(scanner.next().toUpperCase());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			do {
				System.out.println("2. Enter Start Date (dd/mm/yyyy): ");
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
	
			// Validate and set End Date
			do{
				System.out.println("   Enter End Date (dd/MM/yyyy): ");
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
	
			// Validate and set Registration Deadline
			do {
				System.out.println("3. Enter Camp Registration Closing Date (dd/MM/yyyy): ");
				String regCloseDateStr = scanner.next();
	
				try {
					this.registrationDeadline = LocalDate.parse(regCloseDateStr, formatter);
					if((registrationDeadline.isAfter(startDate) || registrationDeadline.isEqual(startDate) )){
						System.out.println("Registration Deadline must be before Start Date! Try Again!");
					}
					//break; // Break the loop if parsing is successful
				} catch (Exception e) {
					System.out.println("Invalid date format. Please try again.");
				}
			} while(registrationDeadline.isAfter(startDate) || registrationDeadline.isEqual(startDate) );
            
        System.out.println("4.Enter UserGroups allowed to join: ");
        System.out.println("  Enter School or Enter ANY if open to whole NTU: ");
            this.userGroup= scanner.next().toUpperCase();


        System.out.println("5.Enter Location: ");
            this.location=scanner.next().toUpperCase();

        System.out.println("6.Enter Total Slots: ");
            this.totalSlots=scanner.nextInt();
        System.out.println("7.Enter Number of Camp Committee Slots: ");   
            this.campCommitteeSlots=scanner.nextInt();
        System.out.println("8.Enter Description ");
            this.description=scanner.next().toUpperCase();
        System.out.println("9. Enter StaffInCharge ");
            this.staffInCharge=scanner.next().toUpperCase();
        System.out.println("Camp Created!");
        
    }
    public String getCampName() {
		return this.campName;
	}

	public void setCampName() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Camp Name: ");
            this.campName=(scanner.next().toUpperCase());
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}
	public LocalDate getEndDate() {
		return this.endDate;
	}
	public void setStartDate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Start Date (dd/MM/yyyy): ");
            String startDateStr = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.startDate = LocalDate.parse(startDateStr, formatter); 
	}
	public void setEndDate() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter End Date (dd/MM/yyyy): ");
            String endDateStr = scanner.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.endDate = LocalDate.parse(endDateStr, formatter);  
	}

	public LocalDate getDeadline() {
		// TODO - implement campInformation.getDeadline
		return this.registrationDeadline;
	}

	public void setDeadline() {
		// TODO - implement campInformation.setDeadline
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Camp Registration Closing Date (dd/MM/yyyy): ");
            String RegCloseDateStr = scanner.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            this.registrationDeadline= LocalDate.parse(RegCloseDateStr, formatter);  
	}

	public int getTotalSlots() {
		return this.totalSlots;
	}

	public void setTotalSlots() {
		Scanner scanner = new Scanner(System.in);
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number of Camp Committee Slots: ");   
            this.campCommitteeSlots=scanner.nextInt();
			
	}

	public String getStaffIC() {
		return this.staffInCharge;
	}

	public void setStaffIC() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter StaffInCharge ");
            this.staffInCharge=scanner.next().toUpperCase();
	}

	public int getAttendeeSlots() {
		return this.totalSlots-this.campCommitteeSlots;
	}

	

	public String getLocation() {
		return this.location;
	}
	
	public void setLocation() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("5.Enter Location: ");
            this.location=scanner.next().toUpperCase();
	}

	public String getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup() {
		// TODO - implement CampInfo.setUserGroup
		Scanner scanner = new Scanner(System.in);
		System.out.println("4.Enter UserGroups allowed to join: ");
        System.out.println("  Enter School or Enter ANY if open to whole NTU: ");
            this.userGroup= scanner.next().toUpperCase();
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription() {
		// TODO - implement CampInfo.setDescription
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Description ");
            this.description=scanner.next().toUpperCase();
	}
}