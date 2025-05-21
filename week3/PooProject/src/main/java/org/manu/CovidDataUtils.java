package org.manu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CovidDataUtils {

    // Calcule le total par mois dans une année et retourne une Map<mois, total>.
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

}
