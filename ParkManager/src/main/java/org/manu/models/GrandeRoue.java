package org.manu.models;

public class GrandeRoue extends Attraction {
    public GrandeRoue(String name, Double price) {
        super(name, price);
    }

    @Override
    public void start() {
        System.out.println(name + " tourne lentement et offre une belle vue.");
    }
}
