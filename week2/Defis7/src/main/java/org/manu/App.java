package org.manu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Path path = Paths.get("./resource/covid_and_trade.csv");

        try {
            List<String> lines = Files.readAllLines(path).stream().skip(1).toList();

            // Récupère tous les Exports de l'UE
            List<CovidData> allData = lines.stream()
                    .map(line -> {
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
                    })
                    .filter(data -> data.getDirection().equals("Exports")
                            && data.getCountry().equals("European Union (27)"))
                    .toList();

            // Grouper par mois et additionner les valeurs pour 2019
            Map<String, Integer> dataByMonth2019 = allData.stream()
                    .filter(data -> data.getYear().equals("2019"))
                    .collect(Collectors.groupingBy(
                            data -> {
                                String[] parts = data.getDate().split("/");
                                return parts[1] + "-" + parts[2]; // MM-yyyy
                            },
                            Collectors.summingInt(data -> {
                                try {
                                    return Integer.parseInt(data.getValue());
                                } catch (NumberFormatException e) {
                                    return 0;
                                }
                            })));

            // Grouper par mois et additionner les valeurs pour 2020
            Map<String, Integer> dataByMonth2020 = allData.stream()
                    .filter(data -> data.getYear().equals("2020"))
                    .collect(Collectors.groupingBy(
                            data -> {
                                String[] parts = data.getDate().split("/");
                                return parts[1] + "-" + parts[2]; // MM-yyyy
                            },
                            Collectors.summingInt(data -> {
                                try {
                                    return Integer.parseInt(data.getValue());
                                } catch (NumberFormatException e) {
                                    return 0;
                                }
                            })));

            // affichage trié par date
            Set<String> allMonths = new TreeSet<>();
            allMonths.addAll(dataByMonth2019.keySet());
            allMonths.addAll(dataByMonth2020.keySet());

            System.out.println("-----------------------------------");
            System.out.println("| Mois | 2019 | 2020 |");
            System.out.println("-----------------------------------");

            for (String month : allMonths) {
                int val2019 = dataByMonth2019.getOrDefault(month, 0);
                int val2020 = dataByMonth2020.getOrDefault(month, 0);
                System.out.printf("%-8s | %-10d | %-10d%n ", month, val2019, val2020);
            }
            System.out.println("-----------------------------------");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
