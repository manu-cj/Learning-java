package com.manu.Defis3.services;

import com.manu.Defis3.models.CovidData;
import com.manu.Defis3.repositories.CovidDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class CovidDataService {
    private CovidDataRepository covidDataRepository;

    /**
     * Calculates the total value for the given month, year, and filters.
     * If a filter parameter is null or empty, a default value is used.
     *
     * @param year the year to filter
     * @param month the month to filter
     * @param country the country to filter (default "All")
     * @param commodity the commodity to filter (default "All")
     * @param transportMode the transport mode to filter (default "All")
     * @param measure the measure to filter (default "$")
     * @return the total value as Double
     */
    public Double monthly_total(int year, int month, String country, String commodity, String transportMode, String measure) {

        // Default value if params is empty or null
        country = (country == null || country.isEmpty()) ? "All" : country;
        commodity = (commodity == null || commodity.isEmpty()) ? "All" : commodity;
        transportMode = (transportMode == null || transportMode.isEmpty()) ? "All" : transportMode;
        measure = (measure == null || measure.isEmpty()) ? "$" : measure;

        List<CovidData> dataList = covidDataRepository.findByMonthAndYearFilters(year, month, country, commodity, transportMode, measure);

        return dataList.stream()
                .mapToDouble(c -> c.getValue() != null ? c.getValue().doubleValue() : 0.0)
                .sum();
    }

    /**
     * Calculates the average value for the given month, year, and filters.
     * If a filter parameter is null or empty, a default value is used.
     *
     * @param year the year to filter
     * @param month the month to filter
     * @param country the country to filter (default "All")
     * @param commodity the commodity to filter (default "All")
     * @param transportMode the transport mode to filter (default "All")
     * @param measure the measure to filter (default "$")
     * @return the average value as Double
     */
    public Double monthly_average(int year, int month, String country, String commodity, String transportMode, String measure) {

        // Default value if params is empty or null
        country = (country == null || country.isEmpty()) ? "All" : country;
        commodity = (commodity == null || commodity.isEmpty()) ? "All" : commodity;
        transportMode = (transportMode == null || transportMode.isEmpty()) ? "All" : transportMode;
        measure = (measure == null || measure.isEmpty()) ? "$" : measure;

        List<CovidData> dataList = covidDataRepository.findByMonthAndYearFilters(year, month, country, commodity, transportMode, measure);

        return dataList.stream()
                .mapToDouble(c -> c.getValue() != null ? c.getValue().doubleValue() : 0.0)
                .average().orElse(0.0);
    }

    /**
     * Calculates the average value for the given year and filters.
     * If a filter parameter is null or empty, a default value is used.
     *
     * @param year the year to filter
     * @param country the country to filter (default "All")
     * @param commodity the commodity to filter (default "All")
     * @param transportMode the transport mode to filter (default "All")
     * @param measure the measure to filter (default "$")
     * @return the average value as Double
     */
    public Double yearly_average(int year, String country, String commodity, String transportMode, String measure) {

        // Default value if params is empty or null
        country = (country == null || country.isEmpty()) ? "All" : country;
        commodity = (commodity == null || commodity.isEmpty()) ? "All" : commodity;
        transportMode = (transportMode == null || transportMode.isEmpty()) ? "All" : transportMode;
        measure = (measure == null || measure.isEmpty()) ? "$" : measure;

        List<CovidData> dataList = covidDataRepository.findByYearFilters(year, country, commodity, transportMode, measure);

        return dataList.stream()
                .mapToDouble(c -> c.getValue() != null ? c.getValue().doubleValue() : 0.0)
                .average().orElse(0.0);
    }

    /**
     * Calculates the total value for the given year and filters.
     * If a filter parameter is null or empty, a default value is used.
     *
     * @param year the year to filter
     * @param country the country to filter (default "All")
     * @param commodity the commodity to filter (default "All")
     * @param transportMode the transport mode to filter (default "All")
     * @param measure the measure to filter (default "$")
     * @return the total value as Double
     */
    public Double yearly_total(int year, String country, String commodity, String transportMode, String measure) {

        // Default value if params is empty or null
        country = (country == null || country.isEmpty()) ? "All" : country;
        commodity = (commodity == null || commodity.isEmpty()) ? "All" : commodity;
        transportMode = (transportMode == null || transportMode.isEmpty()) ? "All" : transportMode;
        measure = (measure == null || measure.isEmpty()) ? "$" : measure;

        List<CovidData> dataList = covidDataRepository.findByYearFilters(year, country, commodity, transportMode, measure);

        return dataList.stream()
                .mapToDouble(c -> c.getValue() != null ? c.getValue().doubleValue() : 0.0)
                .sum();
    }

    public String overview() {
        List<CovidData> dataList = covidDataRepository.findAll();

        if (dataList.isEmpty()) {
            return "No data here";
        } else {
            Set<Integer> years = new HashSet<>();
            Set<String> countries = new HashSet<>();
            Set<String> commodities = new HashSet<>();
            Set<String> transportModes = new HashSet<>();
            Set<String> measures = new HashSet<>();

            for (CovidData datas : dataList) {
                years.add(datas.getYear());
                countries.add(datas.getCountry());
                commodities.add(datas.getCommodity());
                transportModes.add(datas.getTransportMode());
                measures.add(datas.getMeasure());
            }
            StringBuilder sb = new StringBuilder();

            sb.append("Year : ").append(years).append("\n")
                    .append("Country : ").append(countries).append("\n").append("\n")
                    .append("Commodity : ").append(commodities).append("\n").append("\n")
                    .append("Transport modes : ").append(transportModes).append("\n").append("\n")
                    .append("Measures : ").append(measures).append("\n");

            return sb.toString();
        }
    }
}
