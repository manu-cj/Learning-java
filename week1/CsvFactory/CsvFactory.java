package CsvFactory;
import java.util.Scanner;


public class CsvFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a firstname");
        String firstName = scanner.nextLine();
        System.out.println("Enter a lastname");
        String lastName = scanner.nextLine();

        if (firstName.isBlank()) {
            System.out.println("need a firstname");
        } else if(lastName.isBlank()) {
            System.out.println("need a lastname");
        }
        scanner.close();
        
        CsvGenerator generator = new CsvGenerator();
        VisitEntry visit = generator.generateVisit(firstName, lastName);
        System.out.println("Visitor: " + visit.getFirstName() + " " + visit.getLastName() + ", Reason: " + visit.getReason() + ", Department: " + visit.getDepartment() + ", Date: " + visit.getDate());
    }
    
}
