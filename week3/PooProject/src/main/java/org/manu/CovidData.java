package org.manu;

public class CovidData {
    private String direction;
    private String year;
    private String date;
    private String weekday;
    private String country;
    private String commodity;
    private String Transport_mode;
    private String measure;
    private int Value;
    private int cumulative;

    public CovidData(String direction, String year, String date, String weekday, String country, String commodity,
            String transport_mode, String measure, int value, int cumulative) {
        this.direction = direction;
        this.year = year;
        this.date = date;
        this.weekday = weekday;
        this.country = country;
        this.commodity = commodity;
        this.Transport_mode = transport_mode;
        this.measure = measure;
        this.Value = value;
        this.cumulative = cumulative;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getTransport_mode() {
        return Transport_mode;
    }

    public void setTransport_mode(String transport_mode) {
        this.Transport_mode = transport_mode;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        this.Value = value;
    }

    public int getCumulative() {
        return cumulative;
    }

    public void setCumulative(int cumulative) {
        this.cumulative = cumulative;
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
                ", Transport_mode='" + Transport_mode + '\'' +
                ", measure='" + measure + '\'' +
                ", Value=" + Value +
                ", cumulative=" + cumulative +
                '}';
    }
}
