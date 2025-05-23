package org.manu;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.manu.models.CovidData;
import org.manu.services.CovidDataUtils;

class CovidDataUtilsTest {

        @Test
        void testGetYearlyAverageByMonth() {
                // Arrange
                // crée une list<CovidData> avec les données à tester.
                List<CovidData> datas = List.of(
                                new CovidData("Exports", "2020", LocalDate.of(2020, 1, 10), "Friday", "All", "All",
                                                "All", "KG", "100",
                                                "1000"),
                                new CovidData("Imports", "2020", LocalDate.of(2020, 1, 20), "Monday", "All", "All",
                                                "All", "KG", "200",
                                                "1200"),
                                new CovidData("Exports", "2020", LocalDate.of(2020, 2, 5), "Wednesday", "All", "All",
                                                "All", "KG",
                                                "300", "1500"),
                                new CovidData("Other", "2020", LocalDate.of(2020, 2, 10), "Thursday", "All", "All",
                                                "All", "KG", "400",
                                                "1900"), // doit être ignoré parce que direction == other
                                new CovidData("Imports", "2021", LocalDate.of(2021, 1, 15), "Friday", "All", "All",
                                                "All", "KG", "999",
                                                "9999") // doit être ignoré parce que year == 2021
                );

                String country = "All";
                String commodity = "All";
                String transportMode = "All";
                String measure = "KG";

                // Act
                Map<Integer, Double> result = CovidDataUtils.getYearlyAverageByMonth(datas, 2020, country, commodity,
                                transportMode, measure);

                // Assert
                // Le nombre de mois qui seront retournés doit être 2 (janvier et février)
                assertEquals(2, result.size());

                // Mois 1 : (100 + 200) / 2 = 150
                assertEquals(150.0, result.get(1));

                // Mois 2 : (300) / 1 = 300
                assertEquals(300.0, result.get(2));

                // Mois 3 n'existe pas
                assertNull(result.get(3));
        }

        @Test
        void testGetYearlyTotalByMonth() {
                List<CovidData> datas = List.of(
                                new CovidData("Exports", "2020", LocalDate.of(2020, 1, 10), "Friday", "All", "All",
                                                "All", "KG", "100",
                                                "1000"),
                                new CovidData("Imports", "2020", LocalDate.of(2020, 1, 20), "Monday", "All", "All",
                                                "All", "KG", "200",
                                                "1200"),
                                new CovidData("Exports", "2020", LocalDate.of(2020, 2, 5), "Wednesday", "All", "All",
                                                "All", "KG",
                                                "300", "1500"),
                                new CovidData("Other", "2020", LocalDate.of(2020, 2, 10), "Thursday", "All", "All",
                                                "All", "KG", "400",
                                                "1900"),
                                new CovidData("Imports", "2021", LocalDate.of(2021, 1, 15), "Friday", "All", "All",
                                                "All", "KG", "999",
                                                "9999"));
                String country = "All";
                String commodity = "All";
                String transportMode = "All";
                String measure = "KG";

                Map<Integer, Double> result = CovidDataUtils.getYearlyTotalByMonth(datas, 2020, country, commodity,
                                transportMode, measure);

                assertEquals(2, result.size());

                // Mois 1 : (100 + 200) = 300 numèro du mois en paramètre
                assertEquals(300.0, result.get(1));

                // Mois 2 : (300 + 0) = 300
                assertEquals(300.0, result.get(2));

                // Mois 3 n'existe pas
                assertNull(result.get(3));

        }

        @Test
        void testGetMonthlyAverage() {
                List<CovidData> datas = List.of(
                                new CovidData("Exports", "2020", LocalDate.of(2020, 1, 10), "Friday", "All", "All",
                                                "All", "KG", "100",
                                                "1000"),
                                new CovidData("Imports", "2020", LocalDate.of(2020, 1, 20), "Monday", "All", "All",
                                                "All", "KG", "200",
                                                "1200"),
                                new CovidData("Exports", "2020", LocalDate.of(2020, 2, 5), "Wednesday", "All", "All",
                                                "All", "KG",
                                                "300", "1500"),
                                new CovidData("Other", "2020", LocalDate.of(2020, 2, 10), "Thursday", "All", "All",
                                                "All", "KG", "400",
                                                "1900"),
                                new CovidData("Imports", "2021", LocalDate.of(2021, 1, 15), "Friday", "All", "All",
                                                "All", "KG", "999",
                                                "9999"));
                String country = "All";
                String commodity = "All";
                String transportMode = "All";
                String measure = "KG";

                Double result = CovidDataUtils.getMonthlyAverage(datas, 2020, 1, country, commodity,
                                transportMode, measure);

                assertNotNull(result);
                assertEquals(150.0, result);

        }

        @Test
        void testGetMonthlyTotal() {
                List<CovidData> datas = List.of(
                                new CovidData("Exports", "2020", LocalDate.of(2020, 1, 10), "Friday", "All", "All",
                                                "All", "KG", "100",
                                                "1000"),
                                new CovidData("Imports", "2020", LocalDate.of(2020, 1, 20), "Monday", "All", "All",
                                                "All", "KG", "200",
                                                "1200"),
                                new CovidData("Exports", "2020", LocalDate.of(2020, 2, 5), "Wednesday", "All", "All",
                                                "All", "KG",
                                                "300", "1500"),
                                new CovidData("Other", "2020", LocalDate.of(2020, 2, 10), "Thursday", "All", "All",
                                                "All", "KG", "400",
                                                "1900"),
                                new CovidData("Imports", "2021", LocalDate.of(2021, 1, 15), "Friday", "All", "All",
                                                "All", "KG", "999",
                                                "9999"));
                String country = "All";
                String commodity = "All";
                String transportMode = "All";
                String measure = "KG";

                Double result = CovidDataUtils.getMonthlyTotal(datas, 2020, 1, country, commodity,
                                transportMode, measure);

                assertNotNull(result);
                assertEquals(300.0, result);
        }

        @Test
        void testGetYearlyAverage() {
                // Arrange
                // crée une list<CovidData> avec les données à tester.
                List<CovidData> datas = List.of(
                                new CovidData("Exports", "2020", LocalDate.of(2020, 1, 10), "Friday", "All", "All",
                                                "All", "KG", "100",
                                                "1000"),
                                new CovidData("Imports", "2020", LocalDate.of(2020, 1, 20), "Monday", "All", "All",
                                                "All", "KG", "200",
                                                "1200"),
                                new CovidData("Exports", "2020", LocalDate.of(2020, 2, 5), "Wednesday", "All", "All",
                                                "All", "KG",
                                                "300", "1500"),
                                new CovidData("Other", "2020", LocalDate.of(2020, 2, 10), "Thursday", "All", "All",
                                                "All", "KG", "400",
                                                "1900"),
                                new CovidData("Imports", "2021", LocalDate.of(2021, 1, 15), "Friday", "All", "All",
                                                "All", "KG", "999",
                                                "9999"));

                String country = "All";
                String commodity = "All";
                String transportMode = "All";
                String measure = "KG";

                Map<Integer, Double> resultData = CovidDataUtils.getYearlyTotalByMonth(datas, 2020, country, commodity,
                                transportMode, measure);

                Double result = CovidDataUtils.getYearlyAverage(resultData);
                assertEquals(300.0, result);

        }

        @Test
        void testGetYearlyTotal() {
                // Arrange
                // crée une list<CovidData> avec les données à tester.
                List<CovidData> datas = List.of(
                                new CovidData("Exports", "2020", LocalDate.of(2020, 1, 10), "Friday", "All", "All",
                                                "All", "KG", "100",
                                                "1000"),
                                new CovidData("Imports", "2020", LocalDate.of(2020, 1, 20), "Monday", "All", "All",
                                                "All", "KG", "200",
                                                "1200"),
                                new CovidData("Exports", "2020", LocalDate.of(2020, 2, 5), "Wednesday", "All", "All",
                                                "All", "KG",
                                                "300", "1500"),
                                new CovidData("Other", "2020", LocalDate.of(2020, 2, 10), "Thursday", "All", "All",
                                                "All", "KG", "400",
                                                "1900"),
                                new CovidData("Imports", "2021", LocalDate.of(2021, 1, 15), "Friday", "All", "All",
                                                "All", "KG", "999",
                                                "9999"));

                String country = "All";
                String commodity = "All";
                String transportMode = "All";
                String measure = "KG";

                Map<Integer, Double> resultData = CovidDataUtils.getYearlyTotalByMonth(datas, 2020, country, commodity,
                                transportMode, measure);

                Double result = CovidDataUtils.getYearlyTotal(resultData);
                assertEquals(600.0, result);

        }

}
