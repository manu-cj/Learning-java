package com.manu.surface;

public enum Unit {
    
    CENTIMETER("cm", 0.01),
    Millimeter("mm", 0.001),
    METER("m", 1);
    private final String suffix;
    private final double toMeterFactor;

    Unit(String suffix, double toMeterFactor) {
        this.suffix = suffix;
        this.toMeterFactor = toMeterFactor;
    }

    public double toMeters(double value) {
        return value * toMeterFactor;
    }

    // determiner l'unité de mesure
    public static Unit from(String input) {
        for (Unit unit : values()) {
            int start = input.length() - unit.suffix.length();
            if (input.startsWith(unit.suffix, start)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unité inconnue : " + input);
    }
    
    public String getSuffix() {
        return suffix;
    }

    public double getToMeterFactor() {
        return toMeterFactor;
    }
    

}
