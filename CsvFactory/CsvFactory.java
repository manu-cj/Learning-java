package CsvFactory;

public class CsvFactory {
    public static void main(String[] args) {
        //TODO: ask name in console with scanner
        
        CsvGenerator generator = new CsvGenerator();
        VisitEntry visit = generator.generateVisit("Manu", "Carenjot");
        System.out.println("Visitor: " + visit.getFirstName() + " " + visit.getLastName() + ", Reason: " + visit.getReason() + ", Department: " + visit.getDepartment() + ", Date: " + visit.getDate());

        // TODO: create a csv file
    }
    
}
