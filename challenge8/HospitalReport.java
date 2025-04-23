package challenge8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HospitalReport {



   
    public void generateReport(List<HospitalData> data) {
        System.out.println("Hospital Report");
        System.out.println("Date\tCardiology\tRadiology\tVisitors");
        for (HospitalData record : data) {
            System.out.println(record.getDate() + "\t" + record.getCardiology() + "\t\t" + record.getRadiology() + "\t\t" + record.getVisitors());
            // Write in a CSV file
            try  {
                File directory = new File("reports");
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                File file = new File(directory, "Report_" + record.getDate() + ".CSV");
                FileWriter writer = new FileWriter(file);
                writer.write("Date,Cardiology,Radiology,Visitors\n");
                writer.write(record.getDate() + "," + record.getCardiology() + ","+ record.getCardiology() + ","+ record.getVisitors());
                writer.close();
            } catch (IOException e) {
                System.err.println("An error occurred while writing the file: " + e.getMessage());
            }
            
        }
    }

    public void generateSummaryReport(List<HospitalData> data, String month) {
        System.out.println("Summary Report for " + month);
        int totalCardiology = 0;
        int totalRadiology = 0;
        int totalVisitors = 0;

        for (HospitalData hospitalData : data) {
            if (hospitalData.getDate().substring(3, 10).equals(month)) {
                totalCardiology += hospitalData.getCardiology();
                totalRadiology += hospitalData.getRadiology();
                totalVisitors += hospitalData.getVisitors();
            }
        }
        System.out.println("Total Cardiology: " + totalCardiology);
        System.out.println("Total Radiology: " + totalRadiology);
        System.out.println("Total Visitors: " + totalVisitors);
        
        // Write in a CSV file
        try {
            File directory = new File("reports");
            if (!directory.exists()) {
                directory.mkdirs();
            }
        
            File file = new File(directory, "Report_" + month + ".CSV");
            FileWriter writer = new FileWriter(file);
            writer.write("Metric,Total\n");
            writer.write("Cardiology," + totalCardiology + "\n");
            writer.write("Radiology," + totalRadiology + "\n");
            writer.write("Visitors," + totalVisitors + "\n");
            writer.close();
            
            System.out.println("Fichier écrit avec succès : " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
        

       
    }

    
    
}
