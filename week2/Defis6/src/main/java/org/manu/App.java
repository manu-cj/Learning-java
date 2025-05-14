package org.manu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Path path = Paths.get("./resource/covid_and_trade.csv");

        try {
            // filtre les exports de 2019 venant de Chine
            List<CovidData> file = Files.readAllLines(path).stream().skip(1).map(line -> {
                String[] parts = line.split(",");

                CovidData data = new CovidData();
                data.setDirection(parts[0]);
                data.setYear(parts[1]);
                data.setDate(parts[2]);
                data.setWeekday(parts[3]);
                data.setCountry(parts[4]);
                data.setCommodity(parts[5]);
                data.setTransport_Mode(parts[6]);
                data.setMeasure(parts[7]);
                data.setValue(parts[8]);
                data.setCumulative(parts[9]);
                return data;
            }).filter(data -> data.getDirection().equals("Exports")
                    && data.getYear().equals("2019")
                    && data.getCountry().equals("China")
                    && data.getCommodity().equals("All")
                    && data.getTransport_Mode().equals("All"))
                    .toList();

            // retourne la valeur la plus élevé
            file.stream()
                    .max((a, b) -> Double.compare(
                            Double.parseDouble(a.getValue()),
                            Double.parseDouble(b.getValue())))
                    .ifPresent(max -> {
                        System.out.println("Valeur maximale trouvée : " + max.getValue());
                        System.out.println(max);
                    });

        } catch (IOException e) {
            System.out.println("An error occured : " + e);
        }
    }
}