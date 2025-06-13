package com.manu.Defis3.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class CovidDataDto {
    public String direction;
    public int year;
    public LocalDate date;
    public String weekday;
    public String country = "All";
    public String commodity = "All";
    public String transportMode = "All";
    public String measure = "$";
    public Double value;
    public Double cumulative;
}