package org.manu;

import java.util.Scanner;

import org.manu.models.Park;
import org.manu.services.menuManager;

public class App {
    public static void main(String[] args) {
        Park park = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the park manager");
        System.out.println("1 : Create a new park");
        System.out.println("2 : Load a park");
        System.out.println("3 : Quit");
        String mainMenuChoice = scanner.nextLine();

        switch (mainMenuChoice) {
            case "1":
                System.out.println("Write a park name:");
                String parkName = scanner.nextLine();

                double parkPrice = 0.0;
                while (true) {
                    System.out.println("Define an entry price:");
                    String priceInput = scanner.nextLine();
                    try {
                        parkPrice = Double.parseDouble(priceInput);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price. Please enter a valid number.");
                    }
                }
                park = new Park(parkName, parkPrice, false, 0, 1, 100000);
                System.out.println("New park created: " + park.getName());
                menuManager.menu(scanner, park);

                break;
            case "2":
                System.out.println("Feature not implemented yet.");
                break;
            case "3":
                System.out.println("Goodbye!");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Exiting.");
                break;
        }

        scanner.close();
    }
}
