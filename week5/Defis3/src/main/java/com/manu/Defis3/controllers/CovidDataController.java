package com.manu.Defis3.controllers;

import com.manu.Defis3.repositories.CovidDataRepository;
import com.manu.Defis3.services.CovidDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidDataController {

    private final CovidDataService covidDataService;


    @GetMapping("/monthly-total")
    public Double getMonthlyTotal(
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return covidDataService.monthly_total(year, month, country, commodity, transportMode, measure);
    }

    @GetMapping("/monthly-average")
    public Double getMonthlyAverage(
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return covidDataService.monthly_average(year, month, country, commodity, transportMode, measure);
    }

    @GetMapping("/yearly-average")
    public Double getYearlyAverage(
            @RequestParam int year,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return covidDataService.yearly_average(year, country, commodity, transportMode, measure);
    }

    @GetMapping("/yearly-total")
    public Double getYearlyTotal(
            @RequestParam int year,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return covidDataService.yearly_total(year, country, commodity, transportMode, measure);
    }

    @GetMapping("overview")
    public String overview() {
        return covidDataService.overview();
    }

    @GetMapping("help")
    public String help(@RequestParam String command) {
        if (command == null || command.isBlank() || command.equalsIgnoreCase("all")) {
            return """
                    Available commands:
                    - overview: Shows a summary of years, countries, commodities, transport modes, and measures present in the database.
                    - monthly-total: Returns the monthly total filtered by year, month, country, commodity, transport mode, and measure.
                    - monthly-average: Returns the monthly average filtered by year, month, country, commodity, transport mode, and measure.
                    - yearly-total: Returns the yearly total filtered by year, country, commodity, transport mode, and measure.
                    - yearly-average: Returns the yearly average filtered by year, country, commodity, transport mode, and measure.
                    - help <command>: Shows detailed help for a command.
                    """;
        }
        return switch (command.toLowerCase()) {
            case "overview" ->
                    "overview: Shows a summary of unique values for the fields year, country, commodity, transportMode, and measure.";
            case "monthly-total" ->
                    "monthly-total: Calculates the total for a given month. Parameters: year (int), month (int), country (String), commodity (String), transportMode (String), measure (String).";
            case "monthly-average" ->
                    "monthly-average: Calculates the average for a given month. Parameters: year (int), month (int), country (String), commodity (String), transportMode (String), measure (String).";
            case "yearly-total" ->
                    "yearly-total: Calculates the total for a given year. Parameters: year (int), country (String), commodity (String), transportMode (String), measure (String).";
            case "yearly-average" ->
                    "yearly-average: Calculates the average for a given year. Parameters: year (int), country (String), commodity (String), transportMode (String), measure (String).";
            default -> "Unknown command. Use help for the list of commands.";
        };
    }
}