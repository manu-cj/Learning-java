package org.manu.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@AllArgsConstructor
@SuperBuilder
public class Product {
    private final UUID id;
    private final String name;
    private final double price;
    private final String description;
    private final String category;
    private final int stock;
}
