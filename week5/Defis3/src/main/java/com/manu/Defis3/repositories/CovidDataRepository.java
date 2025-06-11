package com.manu.Defis3.repositories;

import com.manu.Defis3.models.CovidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CovidDataRepository extends JpaRepository<CovidData, UUID> {

    @Query("SELECT c FROM CovidData c WHERE (c.direction = 'Exports' OR c.direction = 'Imports') AND YEAR(c.date) = :year AND MONTH(c.date) = :month")
    List<CovidData> findByMonthAndYear(@Param("year") int year, @Param("month") int month);


    @Query("SELECT SUM(c.value) FROM CovidData c WHERE (c.direction = 'Exports' OR c.direction = 'Imports') AND YEAR(c.date) = :year AND MONTH(c.date) = :month")
    Double sumExportImportByMonthAndYear(@Param("year") int year, @Param("month") int month);

    @Query("SELECT SUM(c.value) FROM CovidData c WHERE " +
            "(c.direction = 'Exports' OR c.direction = 'Imports') " +
            "AND YEAR(c.date) = :year " +
            "AND MONTH(c.date) = :month " +
            "AND c.country = :country " +
            "AND c.commodity = :commodity " +
            "AND c.transportMode = :transportMode " +
            "AND c.measure = :measure")
    Double sumByAllFilters(@Param("year") int year,
                           @Param("month") int month,
                           @Param("country") String country,
                           @Param("commodity") String commodity,
                           @Param("transportMode") String transportMode,
                           @Param("measure") String measure);
}
