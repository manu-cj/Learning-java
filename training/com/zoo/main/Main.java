package training.com.zoo.main;
import training.com.zoo.animals.Chien;
import training.com.zoo.animals.Chat;
import training.com.zoo.affichage.Affichable;

public class Main {
    public static void main(String[] args) {
        Chien chien = new Chien("Pascal");
        chien.manger();
        chien.faireDuBruit();
        afficherAnimal(chien);
      

        Chat chat = new Chat("Ivar");
        chat.manger();
        chat.faireDuBruit();
    }

    public static void afficherAnimal(Object animal) {
        if (animal instanceof Affichable) {
            ((Affichable) animal).afficher();
        } else {
            System.out.println("Cet animal n'est pas affichable.");
        }
    }
}
