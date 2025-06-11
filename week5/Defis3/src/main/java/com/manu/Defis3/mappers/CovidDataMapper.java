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
                .value(dto.value)
                .cumulative(dto.cumulative)
                .build();
    }

    public static CovidDataDto toDto(CovidData entity) {
        if (entity == null) return null;
        return CovidDataDto.builder()
                .direction(entity.getDirection())
                .year(entity.getYear())
                .date(entity.getDate())
                .weekday(entity.getWeekday())
                .country(entity.getCountry())
                .commodity(entity.getCommodity())
                .transportMode(entity.getTransportMode())
                .measure(entity.getMeasure())
                .value(entity.getValue())
                .cumulative(entity.getCumulative())
                .build();
    }


}
