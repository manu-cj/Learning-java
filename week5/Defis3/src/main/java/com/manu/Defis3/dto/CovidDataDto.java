package com.manu.Defis3.dto;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public class CovidDataDto {
    public String direction;
    public int year;
    public LocalDate date;
    public String weekday;
    public String country;
    public String commodity;
    public String transportMode;
    public String measure;
    public Double value;
    public Double cumulative;
}