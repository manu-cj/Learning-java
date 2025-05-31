package org.manu.services;

import org.manu.models.Aliment;
import org.manu.models.Product;
import org.manu.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ProductServices {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Add a new aliment
     * @param name
     * @param price
     * @param description
     * @param category
     * @param stock
     * @param type
     * @param date
     */
    public void addAliment( String name, Double price, String description, String category, int stock, String type, LocalDate date) {
        UUID id = UUID.randomUUID();
        Product aliment =  Aliment.builder()
                .id(id)
                .name(name)
                .price(price)
                .description(description)
                .category(category)
                .stock(stock)
                .type(type)
                .date(date)
                .build();
        productRepository.save(aliment);
    }

    /**
     * Return in terminal all products by category choice
     * @param category
     */
    public void getProductsByCategory(String category) {
        List<Product> products = productRepository.getAllProductsByCategory(category);
        if (products.isEmpty()) {
            System.out.println("\n--- Aliment List report ---");
            System.out.println("No Aliment recorded yet");
            System.out.println("---------------------------\n");
        } else {
            System.out.println("\n--- Product in category '" + category + "' ---");
            for (Product product : products) {
                System.out.println("Id : " + product.getId());
                System.out.println("Name : " + product.getName());
                System.out.println("Price : " + product.getPrice());
                System.out.println("Description : " + product.getDescription());
                System.out.println("Stock : " + product.getStock());
                if (product instanceof Aliment aliment) {
                    System.out.println("Type : " + aliment.getType());
                    System.out.println("En date : " + aliment.getDate());
                }
            }
            System.out.println("---------------------------\n");
        }
    }
}
