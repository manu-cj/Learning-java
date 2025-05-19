package org.manu;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvRead {

    public List<CovidData> readCsv() {
        List<CovidData> covidData = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("./resource/covid_and_trade.csv"))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                String direction = parts[0];
                String year = parts[1];
                String date = parts[2];
                String weekday = parts[3];
                String country = parts[4];
                String commodity = parts[5];
                String transport_mode = parts[6];
                String measure = parts[7];
                long value = Long.parseLong(parts[8]);
                long cumulative = Long.parseLong(parts[9]);

                covidData.add(new CovidData(direction, year, date, weekday, country, commodity, transport_mode, measure,
                        value, cumulative));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return covidData;
    }
}
