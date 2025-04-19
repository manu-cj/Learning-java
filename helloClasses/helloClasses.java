package helloClasses;
import java.util.List;

public class helloClasses {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        String filePath = "./person.CSV";

        // Read the CSV file and get the list of Person objects
        List<Person> persons = csvReader.readCsv(filePath);

        // Print the details of each person
        for (Person person : persons) {
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("City: " + person.getCity());
            System.out.println();
        }
    }
    
}


