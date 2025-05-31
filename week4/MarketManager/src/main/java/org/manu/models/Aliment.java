package org.manu.models;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
public class Aliment  extends Product{
    private final String type;
    private final LocalDate date;
}
