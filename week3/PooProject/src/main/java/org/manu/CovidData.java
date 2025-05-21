package org.manu;

import java.time.LocalDate;

public class CovidData {
    private final String direction;
    private final int year;
    private final LocalDate date;
    private final String weekday;
    private final String country;
    private final String commodity;
    private final String transportMode;
    private final String measure;
    private final Long Value;
    private final Long cumulative;

    public CovidData(String direction, String year, LocalDate date, String weekday, String country, String commodity,
            String transportMode, String measure, String value, String cumulative) {
        this.direction = direction;
        this.year = Integer.parseInt(year);
        this.date = date;
        this.weekday = weekday;
        this.country = country;
        this.commodity = commodity;
        this.transportMode = transportMode;
        this.measure = measure;
        this.Value = Long.parseLong(value);
        this.cumulative = Long.parseLong(cumulative);
    }

    public String getDirection() {
        return direction;
    }

    public int getYear() {
        return year;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getCountry() {
        return country;
    }

    public String getCommodity() {
        return commodity;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public String getMeasure() {
        return measure;
    }

    public Long getValue() {
        return Value;
    }

    public Long getCumulative() {
        return cumulative;
    }

    @Override
    public String toString() {
        return "CovidData{" +
                "direction='" + direction + '\'' +
                ", year='" + year + '\'' +
                ", date='" + date + '\'' +
                ", weekday='" + weekday + '\'' +
                ", country='" + country + '\'' +
                ", commodity='" + commodity + '\'' +
                ", TransportMode='" + transportMode + '\'' +
                ", measure='" + measure + '\'' +
                ", Value=" + Value +
                ", cumulative=" + cumulative +
                '}';
    }
}
