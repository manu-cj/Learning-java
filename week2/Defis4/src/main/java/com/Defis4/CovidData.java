package com.Defis4;

public class CovidData {
    String direction;
    Integer year;
    String date;
    String weekday;
    String country;
    String commodity;
    String transport;
    String measure;
    String value;
    String cumulative;

    public CovidData(String direction, Integer year, String date, String weekday, String country,
            String commodity, String transport, String measure, String value, String cumulative) {
        this.direction = direction;
        this.year = year;
        this.date = date;
        this.weekday = weekday;
        this.country = country;
        this.commodity = commodity;
        this.transport = transport;
        this.measure = measure;
        this.value = value;
        this.cumulative = cumulative;
    }

    @Override
    public String toString() {
        return "CovidData{" +
                "direction='" + direction + '\'' +
                ", year=" + year +
                ", date='" + date + '\'' +
                ", weekday='" + weekday + '\'' +
                ", country='" + country + '\'' +
                ", commodity='" + commodity + '\'' +
                ", transport='" + transport + '\'' +
                ", measure='" + measure + '\'' +
                ", value=" + value +
                ", cumulative=" + cumulative +
                '}';
    }
}
