package training.com.zoo.animals;
import training.com.zoo.affichage.Affichable;

public class Chien extends Animal implements Affichable  {
    public Chien(String nom) {
        super(nom);
    }

    public void faireDuBruit() {
        System.out.println("Wouf !");
    }

    @Override
    public void afficher() {
        System.out.println("Ceci est un chien nommé " + nom);
        
    }
    

}
