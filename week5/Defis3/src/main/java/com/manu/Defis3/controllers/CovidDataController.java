package com.manu.Defis3.controllers;

import com.manu.Defis3.repositories.CovidDataRepository;
import com.manu.Defis3.services.CovidDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidDataController {

    private final CovidDataRepository repository;
    private final CovidDataService covidDataService;


    @GetMapping("/repository/monthly-total")
    public Double getMonthlyTotalByRepository(
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return repository.sumByAllFilters(year, month, country, commodity, transportMode, measure);
    }

    @GetMapping("/repository/monthly-average")
    public Double getMonthlyAverageByRepository(
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return repository.avgExportImportByMonthAndYear(year, month, country, commodity, transportMode, measure);
    }

    @GetMapping("/repository/yearly-total")
    public Double getYearlyTotalByRepository(
            @RequestParam int year,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return repository.sumByYearWithAllFilters(year, country, commodity, transportMode, measure);
    }

    @GetMapping("/repository/yearly-average")
    public Double getYearlyAverageByRepository(
            @RequestParam int year,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return repository.avgByYearWithAllFilters(year, country, commodity, transportMode, measure);
    }

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
}