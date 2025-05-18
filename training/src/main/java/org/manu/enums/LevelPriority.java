package org.manu.enums;

public enum LevelPriority {
    Bas(1), Moyen(5), Haut(10);

    private final int valeur;

    LevelPriority(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public boolean isPriority() {
        return this.valeur >= 10;
    }

}
