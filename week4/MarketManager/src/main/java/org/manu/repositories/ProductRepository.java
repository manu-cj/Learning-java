package org.manu.repositories;

import org.manu.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> productRepository = new ArrayList<>();


    /**
     * Save a new product and modify if product already exist
     * @param product
     * @return
     */
    public void save(Product product) {
        if (product.getId() == null) {
            productRepository.add(product);
        } else {
            for (int i = 0; i < productRepository.size(); i++) {
                if (productRepository.get(i).getId().equals(product.getId())) {
                    productRepository.set(i, product);
                    break;
                }
            }
        }
        productRepository.add(product);
    }

    /**
     * Return all product by category
     * @param category
     * @return
     */
    public List<Product> getAllProductsByCategory(String category) {
        return productRepository.stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }

    public List<Product> getAllProducts() {
        return productRepository;
    }
}
