package org.manu.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Park {
    private String name;
    private double price;
    private boolean open;
    private int visitors;
    private int rate;
    private long budget;
    private final List<Attraction> attractions = new ArrayList<>();

    public Park(String name, double price, boolean open, int visitors, int rate, long budget) {
        this.name = name;
        this.price = price;
        this.open = open;
        this.visitors = visitors;
        this.rate = rate;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        this.open = true;
    }

    public void close() {
        this.open = false;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public void addVisitor() {
        this.visitors++;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void addRate() {
        this.rate++;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void removeAttraction(Attraction attraction) {
        attractions.remove(attraction);
    }

    public List<Attraction> getAttractions() {
        return Collections.unmodifiableList(attractions);
    }

    public void startAttractions() {
        for (Attraction attraction : attractions) {
            attraction.start();
            this.budget += attraction.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", open=" + open +
                ", visitors=" + visitors +
                ", rate=" + rate +
                ", budget=" + budget +
                ", attractions=" + attractions.size() +
                '}';
    }
}
