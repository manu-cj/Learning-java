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

        Command command = Command.HELP;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a command");
        String userCommand = scanner.nextLine();
        userCommand.toUpperCase();

        switch (userCommand.toUpperCase()) {
            case "MONTHLY_AVERAGE":
                result = Command.MONTHLY_AVERAGE.execute();
                break;
            case "OVERVIEW":
                Command.OVERVIEW.execute(data);
                break;
            default:
                break;
        }

        System.out.println(result);
        scanner.close();

        // List<CovidData> covidData = new ArrayList<>();

        // try (BufferedReader br =
        // Files.newBufferedReader(Paths.get("./resource/data.csv"))) {
        // String line;
        // br.readLine();

        // while ((line = br.readLine()) != null) {
        // String[] parts = line.split(",");
        // String direction = parts[0];
        // String year = parts[1];
        // String date = parts[2];
        // String weekday = parts[3];
        // String country = parts[4];
        // String commodity = parts[5];
        // String Transport_mode = parts[6];
        // String measure = parts[7];
        // int value = Integer.parseInt(parts[8]);
        // int cumulative = Integer.parseInt(parts[9]);

        // covidData.add(new CovidData(direction, year, date, weekday, country,
        // commodity, Transport_mode, measure,
        // value, cumulative));

        // }

        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // data.stream().toList();

        // for (CovidData each : data) {
        // System.out.println(each);

        // }

    }
}
