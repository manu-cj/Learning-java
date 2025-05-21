package org.manu;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        CsvRead csvRead = new CsvRead();
        List<CovidData> data = csvRead.readCsv();

        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a command");
        String userCommand = scanner.nextLine();
        userCommand = userCommand.toUpperCase();
        Command command = Command.valueOf(userCommand);

        switch (userCommand) {
            case "YEARLY_AVERAGE":
                System.out.println("Write a year");
                String yearYearly = scanner.nextLine();
                System.out.println(command.execute(data, Integer.parseInt(yearYearly)));
                break;
            case "MONTHLY_AVERAGE":
                System.out.println("Write a year");
                String yearMonthly = scanner.nextLine();
                System.out.println("Enter a month in format ('01')");
                String monthly = scanner.nextLine();
                System.out.println(command.execute(data, Integer.parseInt(yearMonthly), Integer.parseInt(monthly)));
                break;
            case "OVERVIEW":
                System.out.println(command.execute(data));

                break;
            default:
                break;
        }

        System.out.println(result);
        scanner.close();

    }
}
