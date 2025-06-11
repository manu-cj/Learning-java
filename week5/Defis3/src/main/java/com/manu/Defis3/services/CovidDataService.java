package com.manu.Defis3.services;

import com.manu.Defis3.models.CovidData;
import com.manu.Defis3.repositories.CovidDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CovidDataService {
    private CovidDataRepository covidDataRepository;

    public Double monthly_total(int year, int month) {
        List<CovidData> dataList = covidDataRepository.findByMonthAndYear(year, month);

        return dataList.stream()
                .mapToDouble(c -> c.getValue() != null ? c.getValue().doubleValue() : 0.0)
                .sum();
    }

}
