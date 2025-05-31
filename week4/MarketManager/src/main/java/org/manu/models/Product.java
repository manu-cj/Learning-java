package org.manu.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private final  String id;
    private final String name;
    private final double price;
    private final String description;
}
