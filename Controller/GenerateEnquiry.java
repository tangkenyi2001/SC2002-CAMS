package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Entity.Camp;

public class GenerateEnquiry implements generateReport{
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
