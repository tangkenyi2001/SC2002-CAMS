package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Entity.Camp;
/**
 * The GenerateEnquiry class implements the generateReport interface to generate the report for enquiries.
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */
public class GenerateEnquiry implements generateReport{

    /**
     * Generates the enquiry report for the selected camp.
     *
     * @param camp The camp for which the enquiry report is generated for.
     * @throws IOException If an I/O error occurs while writing the report to a file.
     */
    public  static void generateReport(Camp camp) throws IOException{
            int i=0;
            File file =new File("Enquries.txt");
            FileWriter fw=new FileWriter(file);
            PrintWriter pw=new PrintWriter(fw);
  
    
            pw.println("Camp: " + camp.getCampInfo().getCampName()); // Print camp name
            pw.println("Enquries ");
            for (i=0;i<camp.getEnquiries().size();i++){
                pw.print("("+(i+1)+")");
                pw.println(camp.getEnquiries().get(i).getStudent().getName()+": ");
                pw.println(camp.getEnquiries().get(i).getContent());
                pw.println(camp.getEnquiries().get(i).getReply());
                }
            System.out.println("Report has been generated as 'Enquries.txt' file ");
            pw.close();
    }
    
}
