package org.manu.models;

public abstract class Attraction {
    protected String name;
    protected Double price;

    public Attraction(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void start();

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}
