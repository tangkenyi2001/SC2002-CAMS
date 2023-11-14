public class main {
    public static void main(String[] args) {
        CampDatabase camper=new CampDatabase();
        camper.addCamps();
        Camp Camp0=camper.getCamps().get(0);

        System.out.println(Camp0.getCampInfo().getCampName());

        System.out.println(Camp0.getCampInfo().getCampName()); 
        CampDatabase a = new CampDatabase();
        Student aStudent=new Student("nil", "nil", "nil","nil");
        Staff aStaff = new Staff("thor" , "thor", "thor", "thor");
        StaffMenu.printMenu(aStaff, CampDatabase.getCamps());



    }
}

