package CsvFactory;

import java.util.ArrayList;

public class CsvGenerator {
    ArrayList<String> reasons = new ArrayList<>();

    public CsvGenerator() {
        reasons.add("Appointment");
        reasons.add("Visit");
    }
    VisitEntry visit = new VisitEntry("Manu", "cj", null, null, null);
    
}
