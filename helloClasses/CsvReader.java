package helloClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<Person> readCsv(String filePath) {
        List<Person> persons = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                
                // get the data from the CSV file
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String city = data[2];  

                
                // Create a Person object with the data from the CSV file
                persons.add(new Person(name, age, city));
            }
            
            reader.close();
      
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return persons;
    }
}
