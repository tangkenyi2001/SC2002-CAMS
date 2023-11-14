public class CampEditor {
    public static void editDates(Camp aCamp){
        aCamp.getCampInfo().setStartDate();
        aCamp.getCampInfo().setEndDate();
        System.out.println("Dates successfully changed!");
    }

    public static void editDeadline(Camp aCamp){
        aCamp.getCampInfo().setDeadline();
        System.out.println("Deadline successfully changed!");
    }

    public static void editDescription(Camp aCamp){
        aCamp.getCampInfo().setDescription();
        System.out.println("Description successfully changed!");
    }

    public static void editSlots(Camp aCamp){
        aCamp.getCampInfo().setTotalSlots();
        aCamp.getCampInfo().setCommitteeSlots();
        System.out.println("Slots successfully changed!");
    }

    public static void editVisibility(Camp aCamp) {
        // if no attendee/committe, then can toggle
        if( aCamp.getAttendees().isEmpty() && aCamp.getCommittee().isEmpty() ){             //i
            if(aCamp.getVisibility()){
                aCamp.setVisibility(false);
            }
            else aCamp.setVisibility(true);
            System.out.println("Visibility successfully changed!");
        }

        else {
            System.out.println("Error : There are attendees or Camp committe members registered!");
        }
    }

    public static void editUserGroup(Camp aCamp) {
        aCamp.getCampInfo().setUserGroup();
        
        System.out.println("UserGroup successfully changed!");
    }


}
