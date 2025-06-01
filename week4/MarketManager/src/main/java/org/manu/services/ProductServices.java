package org.manu.services;

import org.manu.models.Aliment;
import org.manu.models.AlimentFactory;
import org.manu.models.Product;
import org.manu.models.ProductFactory;
import org.manu.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductServices {
    private final ProductRepository productRepository;
    private final Map<String, ProductFactory> factories = Map.of(
            "aliment", new AlimentFactory()
    );

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Add a new product
     * @param name
     * @param price
     * @param description
     * @param category
     * @param stock
     * @param type
     * @param date
     */
    public void addProduct( String name, Double price, String description, String category, int stock, String type, LocalDate date) {
        UUID id = UUID.randomUUID();
        ProductFactory factory = factories.get(category.toLowerCase());
        if (factory == null) throw  new IllegalArgumentException("Category unknow : " + category);
        Product product = factory.create(id, name, price, description, category, stock, type, date);
        productRepository.save(product);
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
