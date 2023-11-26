package Entity;
/**
Represents the Camp Information of a camp.
Each camp has their own set of information, decided by a Staff when the camp is created.
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.io.Serializable;

public class CampInfo implements Serializable{
	/**
	 * Name of the camp.
	 */
	private String campName;
	/**
	 * Start date of the camp.
	 */
	private LocalDate startDate;
	/**
	 * End date of the camp.
	 */
	private LocalDate endDate;
	/**
	 * Registration deadline of the camp.
	 */
	private LocalDate registrationDeadline;
	/**
	 * User group that this camp is open to.
	 */
	private String usergroup;
	/**
	 * Location of the camp.
	 */
    private String location;
	/**
	 * Total number of slots for the camp, inclusive of attendees and camp committee members.
	 */
	private int totalSlots;
	/**
	 * Number of camp committee slots available for the camp.
	 */
	private int campCommitteeSlots;
	/**
	 * Description of the camp.
	 */
	private String description;
	/**
	 * Staff that is in charge of the camp ( The one who created it ).
	 */
	private Staff staffInCharge;

	static Scanner scanner = new Scanner(System.in);
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	/**
	 * Constructor for camp information
	 * @param staff Staff that creaed the camp
	 */
    public CampInfo(Staff staff){
			setCampName();
			setStartDate();
			setEndDate();
			setDeadline();
			setUserGroup();
			setLocation();
			setTotalSlots();
			setCommitteeSlots();
			setDescription();
			this.staffInCharge=staff;
			System.out.println("Camp Created!");
			System.out.println("Default visibility is False!");
			System.out.println("Toggle visibility via edit Camps");
	}

	/**
	 * Return the name of the camp.
	 * @return
	 */
    public String getCampName() {
		return this.campName;
	}
	/**
	 * Sets the name of the camp.
	 */
	public void setCampName() {
		//scanner.nextLine();
		System.out.println("Enter Camp Name: ");
        this.campName=(scanner.nextLine().toUpperCase());
	}
	/**
	 * Returns the start date of the camp.
	 * @return
	 */
	public LocalDate getStartDate() {
		return this.startDate;
	}
	
	/**
	 * Set the start date of the camp.
	 */
	public void setStartDate() {
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

	/**
	 * Returns the end date of the camp.
	 * @return
	 */
	public LocalDate getEndDate() {
		return this.endDate;
	}

	/**
	 * Sets the end date of the camp.
	 */
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
	}

	/**
	 * Returns the deadline for camp registration.
	 * @return
	 */
	public LocalDate getDeadline() {
		return this.registrationDeadline;
	}

	/**
	 * Sets the deadline for the camp registration.
	 */
	public void setDeadline() {
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
	}

	/**
	 * Return the total number of slots.
	 * @return
	 */
	public int getTotalSlots() {
		return this.totalSlots;
	}
	/**
	 * Set the total number of slots.
	 */
	public void setTotalSlots() {
		System.out.println("Enter Total Slots: ");
            this.totalSlots=scanner.nextInt();
	}

	/**
	 * Reduce the number of total slots by 1.
	 */
	public void minusSlot(){
		this.totalSlots--;
	}
	/**
	 * Add 1 to the number of total slots.
	 */
	public void addSlot(){
		this.totalSlots++;
	}
	/**
	 * Reduce the number of committee slots by 1.
	 */
	public void minusCommitteeSlots(){
		this.campCommitteeSlots--;
	}

	/**
	 * Return the number of committee member slots.
	 * @return
	 */
	public int getCommitteeSlots() {
		return this.campCommitteeSlots;
	}
	/**
	 * Set the number of committee slots available.
	 */
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

	/**
	 * Returns the Staff in charge of the camp.
	 * @return
	 */
	public Staff getStaffIC() {
		return this.staffInCharge;
	}

	/**
	 * Returns the number of attendees slot available.
	 * Attendee Slot = Total Slot - Camp Committe Slots.
	 * @return
	 */
	public int getAttendeeSlots() {
		return this.totalSlots-this.campCommitteeSlots;
	}

	
	/**
	 * Returns the location of the camp.
	 * @return
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Sets the location of the camp.
	 */
	public void setLocation() {
		scanner.nextLine();
		System.out.println("Enter Location: ");
		this.location=scanner.nextLine().toUpperCase();

	}

	/**
	 * Return the User group of the camp.
	 * @return
	 */
	public String getUserGroup() {
		return this.usergroup;
	}

	/**
	 * Set the user group of the camp.
	 */
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

	/**
	 * Return the description of the camp.
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set the description of the camp.
	 */
	public void setDescription() {
		scanner.nextLine();
		System.out.println("Enter Description ");
            this.description=scanner.nextLine().toUpperCase();
	}
}