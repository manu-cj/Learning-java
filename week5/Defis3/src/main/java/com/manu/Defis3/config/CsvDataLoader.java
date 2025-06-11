package com.manu.Defis3.config;

import com.manu.Defis3.dto.CovidDataDto;
import com.manu.Defis3.mappers.CovidDataMapper;
import com.manu.Defis3.models.CovidData;
import com.manu.Defis3.repositories.CovidDataRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CsvDataLoader {

    @Autowired
    private CovidDataRepository covidDataRepository;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @PostConstruct
    public void loadData() throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/covid_and_trade.csv")))) {
            reader.lines().skip(1).forEach(line -> {
                String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                CovidDataDto dto = CovidDataDto.builder()
                        .direction(fields[0])
                        .year(Integer.parseInt(fields[1]))
                        .date(LocalDate.parse(fields[2], formatter))
                        .weekday(fields[3])
                        .country(fields[4])
                        .commodity(fields[5])
                        .transportMode(fields[6])
                        .measure(fields[7])
                        .value(Long.parseLong(fields[8]))
                        .cumulative(Long.parseLong(fields[9]))
                        .build();
                CovidData data = CovidDataMapper.toEntity(dto);
                covidDataRepository.save(data);
            });
        }
    }
}