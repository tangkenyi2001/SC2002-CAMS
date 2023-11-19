package Manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Entity.Staff;
import Entity.Student;

public class CsvReader {
    public static void readstaff(){
        String path = "C:/Users/tangk/Documents/GitHub/SC2002-Final/staff_list (3).csv";
        String line="";
        StaffManager staffManager=new StaffManager();
        int count=0;
        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            while ((line=br.readLine())!=null){
                String [] values=line.split(",");

                if (line.trim().isEmpty()|| line.split(",").length == 0) {
                    continue;
                }
                
                System.out.println(values[0]);
                if (count!=0)
                {
                    int indexofat=values[1].indexOf('@');
                    String id = values[1].substring(0,indexofat).toUpperCase();
                    staffManager.addNewStaff(new Staff(id.toUpperCase(),values[0].toUpperCase(),"PASSWORD".toUpperCase(), values[2].toUpperCase()));
                }
                count++;//first loop dont add, if not will add Header in
                
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void readstudent(){
         String path = "C:/Users/tangk/Documents/GitHub/SC2002-Final/student list(1) (4).csv";
         String line="";
         StudentManager studentmanager=new StudentManager();
         int count=0;
         try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            while ((line=br.readLine())!=null){
                if (line.trim().isEmpty()|| line.split(",").length == 0) {
                    continue;
                }
                
                String [] values=line.split(",");
                System.out.println(values[0]);
                int indexofat=values[1].indexOf('@');
                if (count!=0)
                {
                String id = values[1].substring(0,indexofat).toUpperCase();
                studentmanager.addStudent(new Student(id.toUpperCase(),values[0].toUpperCase(),"PASSWORD".toUpperCase(), values[2].toUpperCase()));
                }
                count++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
