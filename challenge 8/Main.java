package helloClasses2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        String filePath = "./hospital.CSV";

        // Read the CSV file and get the list of HospitalData objects
        List<HospitalData> hospitalDataList = csvReader.readCsv(filePath);

        // Generate a report
        HospitalReport report = new HospitalReport();
        report.generateReport(hospitalDataList);
        
        // Generate a summary report
        // Create a set to keep track of months that have already been processed
        Set<String> processedMonths = new HashSet<>();
        for (HospitalData record : hospitalDataList) {
            String mois = record.getDate().substring(3, 10); // "mm-yyyy"

            if (!processedMonths.contains(mois)) {
                report.generateSummaryReport(hospitalDataList, mois);
                processedMonths.add(mois); // Marquer ce mois comme traité
            }
        }
    }
}
