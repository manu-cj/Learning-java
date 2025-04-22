package CsvFactory;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class CsvFactory {
    public static void main(String[] args) {
        //TODO: ask name in console with scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a firstname");
        String firstName = scanner.nextLine();
        System.out.println("Enter a lastname");
        String lastName = scanner.nextLine();

        if (firstName == null) {
            System.out.println("need a firstname");
        } else if(lastName == null) {
            System.out.println("need a lastname");
        }
        
        CsvGenerator generator = new CsvGenerator();
        VisitEntry visit = generator.generateVisit(firstName, lastName);
        System.out.println("Visitor: " + visit.getFirstName() + " " + visit.getLastName() + ", Reason: " + visit.getReason() + ", Department: " + visit.getDepartment() + ", Date: " + visit.getDate());
    }
    
}
