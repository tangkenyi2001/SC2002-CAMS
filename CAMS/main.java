public class main {
    public static void main(String arg[]) {
       /* CampDatabase camper=new CampDatabase();
        camper.addCamps();
        Camp Camp0=camper.getCamps().get(0);
        System.out.println(Camp0.getCampInfo().getCampName()); */
        CampDatabase a = new CampDatabase();
        Staff aStaff = new Staff("thor" , "thor", "thor", "thor");
        StaffMenu.printMenu(aStaff, CampDatabase.getCamps());

    }
}
