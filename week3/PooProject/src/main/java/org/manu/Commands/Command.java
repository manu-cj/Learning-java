package org.manu.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.manu.models.CovidData;
import org.manu.services.CovidDataUtils;

public enum Command {
    HELP {
        @Override
        public String execute() {
            // Returns a list of available commands with a small description.
            return """
                    Available commands:
                    help: List all commands with a short description.
                    help <command>: Show details about a specific command.
                    monthly_total: Sum of export and import for a specified month/year.
                    monthly_average: Average of export and import for a specified month/year.
                    yearly_total: Overview of monthly totals and yearly totals for a year.
                    yearly_average: Overview of monthly averages and yearly averages for a year.
                    overview: List all unique years, countries, commodities, transport modes, and measures.
                    """;
        }

        @Override
        public String execute(String command) {
            // Returns a full explanation of the given command.
            return switch (command.toLowerCase()) {
                case "help" -> "help: Lists all available commands with a short description.";
                case "help <command>" ->
                    "help <command>: Shows a detailed explanation and parameters for the given command.";
                case "monthly_total" ->
                    "monthly_total <year> <month>: Returns the sum of export and import for the specified month and year.";
                case "monthly_average" ->
                    "monthly_average <year> <month>: Returns the average of export and import for the specified month and year.";
                case "yearly_total" ->
                    "yearly_total <year>: Returns monthly totals and yearly totals for both import and export for the specified year.";
                case "yearly_average" ->
                    "yearly_average <year>: Returns monthly averages and yearly averages for both import and export for the specified year.";
                case "overview" ->
                    "overview: Lists all unique years, countries, commodities, transportation modes, and measures in the dataset.";
                default -> "Unknown command: " + command;
            };
        }
    },
    MONTHLY_TOTAL {
        @Override
        public String execute(List<CovidData> datas, int year, int month, String country, String commodity,
                String transportMode,
                String measure) {

            country = CovidDataUtils.defaultIfEmpty(country, "All");
            commodity = CovidDataUtils.defaultIfEmpty(commodity, "All");
            transportMode = CovidDataUtils.defaultIfEmpty(transportMode, "All");
            measure = CovidDataUtils.defaultIfEmpty(measure, "$");

            Double monthlyTotal = CovidDataUtils.getMonthlyAverage(datas, year, month, country, commodity,
                    transportMode, measure);

            return String.format("%.2f", monthlyTotal);
        }

        @Override
        public String execute() {
            return "monthly_total";
        }
    },
    MONTHLY_AVERAGE {
        @Override
        public String execute(List<CovidData> datas, int year, int month, String country, String commodity,
                String transportMode,
                String measure) {

            country = CovidDataUtils.defaultIfEmpty(country, "All");
            commodity = CovidDataUtils.defaultIfEmpty(commodity, "All");
            transportMode = CovidDataUtils.defaultIfEmpty(transportMode, "All");
            measure = CovidDataUtils.defaultIfEmpty(measure, "$");

            Double monthlyAvg = CovidDataUtils.getMonthlyAverage(datas, year, month, country, commodity, transportMode,
                    measure);

            return String.format("%.2f", monthlyAvg);
        }

        @Override
        public String execute() {
            return "monthly_average";
        }
    },
    YEARLY_TOTAL {
        @Override
        public String execute(List<CovidData> datas, int year, String country, String commodity, String transportMode,
                String measure) {

            country = CovidDataUtils.defaultIfEmpty(country, "All");
            commodity = CovidDataUtils.defaultIfEmpty(commodity, "All");
            transportMode = CovidDataUtils.defaultIfEmpty(transportMode, "All");
            measure = CovidDataUtils.defaultIfEmpty(measure, "$");

            Map<Integer, Double> totalByMonth = CovidDataUtils.getYearlyTotalByMonth(datas, year, country, commodity,
                    transportMode, measure);

            List<String> lines = new ArrayList<>();
            lines.add("Monthly total for " + year + ":");

            CovidDataUtils.addMonthInList(totalByMonth, lines);

            Double totalYear = CovidDataUtils.getYearlyTotal(totalByMonth);
            lines.add("Total for year " + year + ": " + String.format("%.2f", totalYear));

            return String.join("\n", lines);
        }

        @Override
        public String execute() {
            return "yearly_total";
        }
    },
    YEARLY_AVERAGE {
        @Override
        public String execute(List<CovidData> datas, int year, String country, String commodity, String transportMode,
                String measure) {

            country = CovidDataUtils.defaultIfEmpty(country, "All");
            commodity = CovidDataUtils.defaultIfEmpty(commodity, "All");
            transportMode = CovidDataUtils.defaultIfEmpty(transportMode, "All");
            measure = CovidDataUtils.defaultIfEmpty(measure, "$");

            Map<Integer, Double> avgByMonth = CovidDataUtils.getYearlyAverageByMonth(datas, year, country, commodity,
                    transportMode, measure);

            List<String> lines = new ArrayList<>();
            lines.add("Monthly averages for " + year + ":");

            CovidDataUtils.addMonthInList(avgByMonth, lines);
            Map<Integer, Double> totalAnnual = CovidDataUtils.getYearlyTotalByMonth(datas, year, country, commodity,
                    transportMode, measure);

            double avgYear = CovidDataUtils.getYearlyAverage(totalAnnual);
            lines.add("Average for year " + year + ": " + String.format("%.2f", avgYear));

            return String.join("\n", lines);
        }

        @Override
        public String execute() {
            return "yearly_average";
        }
    },
    OVERVIEW {
        @Override
        public String execute(List<CovidData> datas) {
            String years = datas.stream().map(CovidData::getYear).distinct().sorted().map(String::valueOf)
                    .collect(Collectors.joining(", "));

            String countries = datas.stream().map(CovidData::getCountry).distinct().sorted()
                    .collect(Collectors.joining(", "));

            String commodities = datas.stream().map(CovidData::getCommodity).distinct().sorted()
                    .collect(Collectors.joining(", "));

            String transportModes = datas.stream().map(CovidData::getTransportMode).distinct().sorted()
                    .collect(Collectors.joining(", "));

            String measures = datas.stream().map(CovidData::getMeasure).distinct().sorted()
                    .collect(Collectors.joining(", "));

            return """
                    The unique values that span the data set: years, countries, commodities, transportation modes and measures.
                    ----------------------------------------------------------------
                    Years: %s
                    Countries: %s
                    Commodities: %s
                    Transport Modes: %s
                    Measures: %s
                    """
                    .formatted(years, countries, commodities, transportModes, measures);
        }

        @Override
        public String execute() {
            return "overview";
        }
    };

    // Méthodes abstraites

    public abstract String execute();

    // Pour les commandes qui prennent un String paramètre (ex: help <command>)
    public String execute(String command) {
        return "This command does not support detailed help.";
    }

    // Pour les commandes qui prennent une liste de données
    public String execute(List<CovidData> datas) {
        return "This command does not support this operation.";
    }

    // Pour les commandes qui prennent liste de données + int year
    public String execute(List<CovidData> datas, int year, String country, String commodity, String transportMode,
            String measure) {
        return "This command does not support this operation.";
    }

    // Pour les commandes qui prennent liste de données + year + month
    public String execute(List<CovidData> datas, int year, int month, String country, String commodity,
            String transportMode, String measure) {
        return "This command does not support this operation.";
    }

}
