package com.manu.Defis3.mappers;

import com.manu.Defis3.dto.CovidDataDto;
import com.manu.Defis3.models.CovidData;

public class CovidDataMapper {
    public static CovidData toEntity(CovidDataDto dto) {
        return CovidData.builder()
                .direction(dto.direction)
                .year(dto.year)
                .date(dto.date)
                .weekday(dto.weekday)
                .country(dto.country)
                .commodity(dto.commodity)
                .transportMode(dto.transportMode)
                .measure(dto.measure)
                .Value(dto.value)
                .cumulative(dto.cumulative)
                .build();
    }
}
