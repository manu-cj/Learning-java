package helloClasses2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<HospitalData> readCsv(String filePath) {
        List<HospitalData> hospitalDataList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line and add to hospitalDataList
                String[] data = line.split(",");
                String date = data[0];
                int cardiology = Integer.parseInt(data[1]);
                int radiology = Integer.parseInt(data[2]);
                int visitors = Integer.parseInt(data[3]);

                // Create a HospitalData object with the data from the CSV file
                hospitalDataList.add(new HospitalData(date, cardiology, radiology, visitors));

                // Example: hospitalDataList.add(parseLine(line));
            }
            reader.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return hospitalDataList;
    }
}


