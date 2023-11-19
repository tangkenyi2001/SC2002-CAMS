package Controller;

import Manager.CsvReader;

public class IntialiseHandler {
    public static void loaddata() {
        CsvReader.readstaff();
        CsvReader.readstudent();
    }
}
