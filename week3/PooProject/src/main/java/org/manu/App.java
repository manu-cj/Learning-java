package org.manu;

import java.util.List;
import java.util.Scanner;

import org.manu.Commands.Command;
import org.manu.models.CovidData;
import org.manu.services.CsvRead;

public class App {
    public static void main(String[] args) {

        CsvRead csvRead = new CsvRead();
        List<CovidData> data = csvRead.readCsv();

        String result;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write a command :");
            String inputLine = scanner.nextLine().trim().toUpperCase();
            String[] words = inputLine.split(" ");

            if (words.length == 0 || words[0].isBlank()) {
                System.out.println("Aucune commande entrée.");
                scanner.close();
                return;
            }

            String userCommand = words[0];

            Command command;
            try {
                command = Command.valueOf(userCommand);
            } catch (IllegalArgumentException e) {
                System.out.println("Cette commande n'existe pas");
                scanner.close();
                return;
            }

            switch (command) {
                case HELP -> {
                    if (words.length > 1) {
                        result = command.execute(words[1]);
                    } else {
                        result = command.execute();
                    }
                }

                case OVERVIEW -> result = command.execute(data);
                case YEARLY_AVERAGE -> {
                    System.out.println("Entre l'année :");
                    String year = scanner.nextLine();
                    result = command.execute(data, Integer.parseInt(year));
                }

                case MONTHLY_AVERAGE, MONTHLY_TOTAL -> {
                    System.out.println("Entre l'année :");
                    String year = scanner.nextLine();
                    System.out.println("Entre le mois dans le format ('01') :");
                    String month = scanner.nextLine();
                    result = command.execute(data, Integer.parseInt(year), Integer.parseInt(month));
                }

                case YEARLY_TOTAL -> {
                    System.out.println("Entre l'année :");
                    String year = scanner.nextLine();
                    result = command.execute(data, Integer.parseInt(year));
                }

                default -> result = "Commande non reconnue";
            }

            System.out.println(result);
            scanner.close();
        }
    }
}
