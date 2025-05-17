package org.manu;

import java.util.ArrayList;

public class Person {
    private int id;
    private String name;
    private int age;
    private String email;
    private String city;

    public Person(int id, String name, int age, String email, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public Person getuserById(int id) {
        if (id == this.id) {
            return this;
        }
        return null;

    }

    @Override
    public String toString() {
        return name + " (" + age + "ans) habite à " + city + "! \nadresse mail de contact : " + email;
    }

}
