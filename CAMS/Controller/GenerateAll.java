package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Entity.Camp;
/**
 * The GenerateAll class implements the generateReport interface to generate a full list of participants for a Camp.
 * This report includes information about attendees and camp committee members and their points.
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */

public class GenerateAll implements generateReport{
    /**
     * Generates names of attendees and camp committee members and their points for the selected camp as a report.
     *
     * @param camp The camp for which the generate all report is generated for.
     * @throws IOException If an I/O error occurs while writing the report to a file.
     */
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
            System.out.println("Report has been generated as 'AllStudents.txt' file ");
            pw.close();
    }
}
