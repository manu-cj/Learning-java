package org.manu.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class VisitorReport {
    Visitor visitor;
    String doctorName;
    String purpose;
    LocalDateTime timestamp;
}
