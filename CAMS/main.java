public class main {
    public static void main(String[] args) {
        CampDatabase camper=new CampDatabase();
        camper.addCamps();
        Camp Camp0=camper.getCamps().get(0);
        System.out.println(Camp0.getCampInfo().getCampName());

    }
}
