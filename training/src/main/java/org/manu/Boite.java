package org.manu;

public class Boite<T> {
    private T contenu;

    public T getContenu() {
        return this.contenu;
    }

    public void setContenu(T contenu) {
        this.contenu = contenu;
    }
}
