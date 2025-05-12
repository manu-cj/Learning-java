package training.com.zoo.animals;

abstract class Animal {
    String nom;
    public Animal(String nom) {
        this.nom = nom;
    }
    public void manger() {
        System.out.println(nom + " mange");
    }

    abstract void faireDuBruit();

}

