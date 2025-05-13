package com.Defis4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Path path = Paths.get("./resource/covid_and_trade.csv");

        try {
            List<CovidData> allLines = Files.lines(Path.of("./resource/covid_and_trade.csv"))
                    .skip(1)
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new CovidData(
                                parts[0], // direction
                                Integer.parseInt(parts[1]), // year
                                parts[2], // date
                                parts[3], // weekday
                                parts[4], // country
                                parts[5], // commodity
                                parts[6], // transport
                                parts[7], // measure
                                parts[8], // value
                                parts[9] // cumulative
                        );
                    }).filter(data -> data.direction.equals("Exports") || data.direction.equals("Imports"))
                    .toList();

            allLines.forEach(data -> {
                if (data.measure.equals("$")) {
                    data.value = String.valueOf(changeInEuros(data.value));
                    System.out.println(data);
                }
            });
        } catch (IOException e) {
            System.out.println("Une erreur est survenue : " + e);
        }
    }

    public static Double changeInEuros(String value) {
        double result = Double.parseDouble(value) * 0.92;
        return Math.round(result * 10.0) / 10.0;
    }

}
