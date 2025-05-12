package Challenge9;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class CsvGenerator {

    private final RandomPicker<String> choiceReason;
    private final RandomPicker<String> choiceDepartment;

    public CsvGenerator() {

        List<String> reasons = List.of("Appointment", "Visit");
        List<String> departments = List.of("Cardiology", "Radiology", "Pediatrics", "Geriatrics", "Pulmonology");

        // pick a random data
        choiceReason = new RandomPicker<>(reasons);
        choiceDepartment = new RandomPicker<>(departments);
    }

    public VisitEntry generateVisit(String firstname, String lastName) {
        String reason = choiceReason.pickRandom();
        String department = choiceDepartment.pickRandom();

        // Create a random date in this year
        LocalDate randomDate = LocalDate.ofYearDay(
                LocalDate.now().getYear(),
                ThreadLocalRandom.current().nextInt(1, LocalDate.now().lengthOfYear() + 1));

        // return a new visit entry in csv file
        File directory = new File("visits");
                if (!directory.exists()) {
                    directory.mkdirs();
                }

        VisitEntry visitEntry = new VisitEntry(firstname, lastName, reason, department, randomDate);
        File file = new File(directory, "Report_" + "visit_" + lastName + "_" + firstname + ".csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            writer.write("Firstname,Lastname,Reason,Department,Date\n");
            writer.write(String.join(",", firstname, lastName, reason, department, randomDate.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitEntry;

    }

}
