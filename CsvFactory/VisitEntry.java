package CsvFactory;

import java.time.LocalDate;

public class VisitEntry {
    String firstName;
    String lastName;
    String reason;
    String department;
    LocalDate date;

    public VisitEntry(
        String firstName,
        String lastName, 
        String reason, 
        String department, 
        LocalDate date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reason = reason;
        this.department = department;
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
