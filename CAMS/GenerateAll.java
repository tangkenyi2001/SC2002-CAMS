package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Entity.Camp;

public class GenerateAll implements generateReport{
    public  static void generateReport(Camp camp) throws IOException{
            int i=0;
            File file =new File("AllStudents.txt");
            FileWriter fw=new FileWriter(file);
            PrintWriter pw=new PrintWriter(fw);
  
    
            pw.println("Camp: " + camp.getCampInfo().getCampName()); // Print camp name
            pw.println("Attendees ");
            for (i=0;i<camp.getAttendees().size();i++){
                pw.print("("+(i+1)+")");
                pw.println(camp.getAttendees().get(i).getName());
                }
            pw.println("Camp Committee ");
            for (i=0;i<camp.getCommittee().size();i++){
                pw.print("("+(i+1)+")");
                pw.println(camp.getCommittee().get(i).getName() + " Points:"+camp.getCommittee().get(i).getPoints());
                }
            System.out.println("Report has been generated as 'All.txt' file ");
            pw.close();
    }
}
