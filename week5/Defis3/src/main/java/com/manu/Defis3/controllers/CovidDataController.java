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



    @GetMapping("/sum")
    public Double getSumExportImport(
            @RequestParam int year,
            @RequestParam int month) {
        return repository.sumExportImportByMonthAndYear(year, month);
    }

    @GetMapping("/test/monthly-total")
    public Double getMonthlyTotal(
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam String country,
            @RequestParam String commodity,
            @RequestParam String transportMode,
            @RequestParam String measure
    ) {
        return repository.sumByAllFilters(year, month, country, commodity, transportMode, measure);
    }

    @GetMapping("/monthly-total")
    public Double getMonthlyTotal(@RequestParam int year, @RequestParam int month) {
        return covidDataService.monthly_total(year, month);
    }
}