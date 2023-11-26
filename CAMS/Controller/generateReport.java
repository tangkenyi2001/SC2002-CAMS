package Controller;

import Entity.Camp;
/**
 * The generateReport interface provides an interface for classes that generate reports for a Camp.
 * Classes implementing this interface should implement the method to generate the report.
 *
 * @author Tang Ken Yi
 * @version 1.0
 * @since 2023-11-26
 */
public interface generateReport {
    /**
     * Generates a report for the selected camp.
     *
     * @param camp The camp for which the report is generated.
     */
    public static void generateReport(Camp camp){};
    
}
