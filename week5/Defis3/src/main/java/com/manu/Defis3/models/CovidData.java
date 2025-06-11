package com.manu.Defis3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "covidData")
public class CovidData {
    @Id
    @GeneratedValue
    private UUID id;
    private  String direction;
    private int year;
    private LocalDate date;
    private String weekday;
    private String country;
    private String commodity;
    private String transportMode;
    private String measure;
    private Long Value;
    private Long cumulative;
}
