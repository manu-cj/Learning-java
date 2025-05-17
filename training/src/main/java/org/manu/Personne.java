package org.manu;

public class Personne {
    String nom;
    int age;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Méthode pour dire si la personne est majeure
    public boolean estMajeur() {
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }
}