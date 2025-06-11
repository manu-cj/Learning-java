package com.manu.Defis3.repositories;

import com.manu.Defis3.models.CovidData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CovidDataRepository extends JpaRepository<CovidData, UUID> {
}
