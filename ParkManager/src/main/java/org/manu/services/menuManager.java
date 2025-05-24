package org.manu.services;

import java.util.Random;
import java.util.Scanner;

import org.manu.models.Coaster;
import org.manu.models.GrandeRoue;
import org.manu.models.Park;

public class menuManager {

    public static void menu(Scanner scanner, Park park) {
        System.out.println("1 Create a new attraction :");
        System.out.println("2 Show all attractions :");
        System.out.println("3 get budget :");
        System.out.println("4 get visitors :");
        if (!park.isOpen()) {
            System.out.println("5 open the park");
        } else {
            System.out.println("close the park");
        }

        System.out.println("6 Quit :");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                choiceAttraction(scanner, park);
                break;
            case "2":
                park.startAttractions();
                break;
            case "3":
                System.out.println(park.getBudget());
                menu(scanner, park);
                break;
            case "4":
                System.out.println(park.getVisitors());
                menu(scanner, park);
                break;
            case "5":
                if (!park.isOpen()) {
                    park.open();
                    openPark(park);
                } else {
                    park.close();
                }
                break;
            case "6":
                System.out.println("Goodbye !");
                break;
            default:
                throw new AssertionError();
        }

    }

    public static void choiceAttraction(Scanner scanner, Park park) {
        System.out.println("Choose attraction type:");
        System.out.println("1. Big wheel (5000$)");
        System.out.println("2. Coaster (15 000$)");
        String choice = scanner.nextLine();

        String name;
        double price;
        long parkBudget = park.getBudget();

        switch (choice) {
            case "1":
                if ((parkBudget - 5000) > 0) {
                    park.setBudget(parkBudget - 5000);
                    System.out.print("Enter the name for the Big wheel: ");
                    name = scanner.nextLine();
                    price = promptForPrice(scanner);
                    park.addAttraction(new GrandeRoue(name, price));
                    System.out.println(name + " added successfully.");
                    menu(scanner, park);
                } else {
                    System.out.println("You don't have a monney for this !");
                    menu(scanner, park);
                }

                break;
            case "2":
                if ((parkBudget - 15000) > 0) {
                    park.setBudget(parkBudget - 15000);
                    System.out.print("Enter the name for the coaster: ");
                    name = scanner.nextLine();
                    price = promptForPrice(scanner);
                    park.addAttraction(new Coaster(name, price));
                    System.out.println(name + " added successfully.");
                    menu(scanner, park);
                } else {
                    System.out.println("You don't have a monney for this !");
                    menu(scanner, park);
                }
                menu(scanner, park);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    private static double promptForPrice(Scanner scanner) {
        double price = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the price: ");
            String input = scanner.nextLine();
            try {
                price = Double.parseDouble(input);
                if (price < 0) {
                    System.out.println("Price cannot be negative. Try again.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a valid number.");
            }
        }
        return price;
    }

    public static void openPark(Park park) {
        for (int i = 0; i < 1000; i++) {
            long addTicket = park.getBudget() + (long) park.getPrice();
            park.setBudget(addTicket);
            park.addVisitor();
            if (i % 4 == 0) {
                park.startAttractions();
                System.out.println("budget actuel : " + park.getBudget());
                Random rand = new Random();
                if (i > 0) {
                    park.setVisitors(park.getVisitors() - rand.nextInt(i));
                }
            }

        }
    }

}
