package org.manu.enums;

public class Planning {
    private Day day;
    private String message;

    public Planning(Day day, String message) {
        this.day = day;
        this.message = message;
    }

    public static String showDay(Day day) {
        return "On est " + day;

    }

}
