package org.manu.models;

import java.time.LocalDate;
import java.util.UUID;

// AlimentFactory.java
public class AlimentFactory implements ProductFactory {
    @Override
    public Product create(UUID id, String name, Double price, String description, String category, int stock, String type, LocalDate date) {
        return Aliment.builder()
                .id(id)
                .name(name)
                .price(price)
                .description(description)
                .category(category)
                .stock(stock)
                .type(type)
                .date(date)
                .build();
    }
}
