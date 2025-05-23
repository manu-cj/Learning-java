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
            System.out.println("Enter a command:");
            String inputLine = scanner.nextLine().trim().toUpperCase();
            String[] words = inputLine.split(" ");

            if (words.length == 0 || words[0].isBlank()) {
                System.out.println("No command entered.");
                scanner.close();
                return;
            }

            String userCommand = words[0];

            Command command;
            try {
                command = Command.valueOf(userCommand);
            } catch (IllegalArgumentException e) {
                System.out.println("This command does not exist");
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
                    System.out.println("Enter the year:");
                    String year = scanner.nextLine();
                    System.out.println("Specify the country:");
                    String country = scanner.nextLine();
                    System.out.println("Specify the commodity:");
                    String commodity = scanner.nextLine();
                    System.out.println("Specify the transport mode:");
                    String transportMode = scanner.nextLine();
                    System.out.println("Specify the measure:");
                    String measure = scanner.nextLine();

                    result = command.execute(data, Integer.parseInt(year), country, commodity, transportMode, measure);
                }

                case MONTHLY_AVERAGE, MONTHLY_TOTAL -> {
                    System.out.println("Enter the year:");
                    String year = scanner.nextLine();
                    System.out.println("Enter the month in format ('01'):");
                    String month = scanner.nextLine();
                    System.out.println("Specify the country:");
                    String country = scanner.nextLine();
                    System.out.println("Specify the commodity:");
                    String commodity = scanner.nextLine();
                    System.out.println("Specify the transport mode:");
                    String transportMode = scanner.nextLine();
                    System.out.println("Specify the measure:");
                    String measure = scanner.nextLine();
                    result = command.execute(data, Integer.parseInt(year), Integer.parseInt(month), country, commodity,
                            transportMode, measure);
                }

                case YEARLY_TOTAL -> {
                    System.out.println("Enter the year:");
                    String year = scanner.nextLine();
                    System.out.println("Specify the country:");
                    String country = scanner.nextLine();
                    System.out.println("Specify the commodity:");
                    String commodity = scanner.nextLine();
                    System.out.println("Specify the transport mode:");
                    String transportMode = scanner.nextLine();
                    System.out.println("Specify the measure:");
                    String measure = scanner.nextLine();
                    result = command.execute(data, Integer.parseInt(year), country, commodity, transportMode, measure);
                }

                default -> result = "Command not recognized";
            }

            System.out.println(result);
            scanner.close();
        }
    }
}
