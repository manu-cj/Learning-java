package org.manu;

public class App {
    public static void main(String[] args) {
        Personne[] personnes = {
                new Personne("Alice", 17),
                new Personne("Bob", 20),
                new Personne("Clara", 18)
        };

        for (int i = 0; i < personnes.length; i++) {
            if (personnes[i].estMajeur()) {
                System.out.println(personnes[i].nom + " est majeur(e).");
            }
        }
    }

}
