package training.com.zoo.animals;

public class Chat extends Animal {
    public Chat(String nom) {
        super(nom);
    }

    public void faireDuBruit() {
        System.out.println("Miaou !");
    }
}
