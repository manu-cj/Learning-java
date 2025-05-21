package org.manu;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvRead {

    public List<CovidData> readCsv() {
        List<CovidData> covidData = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("./resource/covid_and_trade.csv"))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                String direction = parts[0].trim();
                String year = parts[1].trim();
                LocalDate date = LocalDate.parse(parts[2].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String weekday = parts[3];
                String country = parts[4];
                String commodity = parts[5];
                String transportMode = parts[6];
                String measure = parts[7];
                String value = parts[8];
                String cumulative = parts[9];

                covidData.add(new CovidData(direction, year, date, weekday, country, commodity,
                        transportMode, measure, value, cumulative));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return covidData;
    }
}
