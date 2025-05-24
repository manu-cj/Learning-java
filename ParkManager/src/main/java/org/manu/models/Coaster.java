package org.manu.models;

public class Coaster extends Attraction {
    public Coaster(String name, Double price) {
        super(name, price);
    }

    @Override
    public void start() {
        System.out.println(name + " file à toute allure sur les rails !");
    }
}
