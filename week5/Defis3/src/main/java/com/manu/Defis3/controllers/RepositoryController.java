package com.manu.Defis3.controllers;

import com.manu.Defis3.repositories.CovidDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@RequestMapping("/repository")
public class RepositoryController {
    private final CovidDataRepository repository;


    @GetMapping("/monthly-total")
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

    @GetMapping("/monthly-average")
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

    @GetMapping("/yearly-total")
    public Double getYearlyTotalByRepository(
            @RequestParam int year,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return repository.sumByYearWithAllFilters(year, country, commodity, transportMode, measure);
    }

    @GetMapping("/yearly-average")
    public Double getYearlyAverageByRepository(
            @RequestParam int year,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return repository.avgByYearWithAllFilters(year, country, commodity, transportMode, measure);
    }
}
