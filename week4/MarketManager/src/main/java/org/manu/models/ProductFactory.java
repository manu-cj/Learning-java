package org.manu.models;

import java.time.LocalDate;
import java.util.UUID;

public interface ProductFactory {
    Product create(UUID id, String name, Double price, String description, String category, int stock, String type, LocalDate date);
}
