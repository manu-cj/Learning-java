import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] numbers = new Integer[10]; // Tableau de 10 éléments

        // Remplir le tableau avec des nombres aléatoires entre -10 et 10
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(11); // Génère des nombres entre -10 et 10
        }

        // Afficher les nombres générés
        System.out.print("Tableau généré : ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Effectuer des divisions et gérer les exceptions
        for (int i = 0; i < numbers.length; i++) {
            try {
                if (i == 0) {
                    System.out.println(numbers[i] + " / " + numbers[i] + " = " + (numbers[i] / numbers[i]));
                } else {
                    System.out.println(numbers[i] + " / " + numbers[i - 1] + " = " + (numbers[i] / numbers[i - 1]));
                }
            } catch (ArithmeticException e) {
                System.out.println("Division par zéro détectée, opération ignorée.");
            }
        }
    }
}