package org.manu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CovidDataUtils {

    // Calcule la somme des valeurs (import + export) pour un mois donné d'une année
    // donnée
    public static Double getMonthlyTotal(List<CovidData> datas, int year, int month) {
        return datas.stream()
                .filter(data -> data.getYear() == year)
                .filter(data -> data.getDate().getMonthValue() == month)
                .filter(data -> data.getDirection().equals("Exports") || data.getDirection().equals("Imports"))
                .mapToDouble(CovidData::getValue)
                .sum();
    }

    // Calcule la moyenne des valeurs (import + export) pour un mois donné d'une
    // année donnée
    public static Double getMonthlyAverage(List<CovidData> datas, int year, int month) {
        return datas.stream()
                .filter(data -> data.getYear() == year)
                .filter(data -> data.getDate().getMonthValue() == month)
                .filter(data -> data.getDirection().equals("Exports") || data.getDirection().equals("Imports"))
                .mapToDouble(CovidData::getValue)
                .average()
                .orElse(0);
    }

    // Calcule le total par mois dans une année et retourne une Map<mois, total>
    public static Map<Integer, Double> getYearlyTotalByMonth(List<CovidData> datas, int year) {
        return datas.stream()
                .filter(data -> data.getYear() == year)
                .filter(data -> data.getDirection().equals("Exports") || data.getDirection().equals("Imports"))
                .collect(Collectors.groupingBy(
                        data -> data.getDate().getMonthValue(),
                        Collectors.summingDouble(CovidData::getValue)));
    }

    // Calcul de le total annuelle et retourne un Double
    public static Double getYearlyTotal(Map<Integer, Double> datas) {
        return datas.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    // Calcule la moyenne par mois dans une année et retourne une Map<mois, moyenne>
    public static Map<Integer, Double> getYearlyAverageByMonth(List<CovidData> datas, int year) {
        return datas.stream()
                .filter(data -> data.getYear() == year)
                .filter(data -> data.getDirection().equals("Exports") || data.getDirection().equals("Imports"))
                .collect(Collectors.groupingBy(
                        data -> data.getDate().getMonthValue(),
                        Collectors.averagingDouble(CovidData::getValue)));
    }

    // Calcul de la moyenne annuelle et retourne un Double
    public static Double getYearlyAverage(Map<Integer, Double> datas) {
        return datas.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    // Pour chaque mois (trié), on ajoute une ligne avec le resultat correspondant
    public static List<String> addMonthInList(Map<Integer, Double> datas, List<String> lines) {
        datas.keySet().stream().sorted().forEach(month -> {
            String line = "Month " + month + ": " + String.format("%.2f", datas.get(month));
            lines.add(line);
        });

        return lines;
    }

}
