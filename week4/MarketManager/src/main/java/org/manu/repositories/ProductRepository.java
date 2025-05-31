package org.manu.repositories;

import org.manu.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> productRepository = new ArrayList<>();


    /**
     * Save a new product and modify if product already exist
     * @param product
     * @return
     */
    public Product save(Product product) {
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
        return product;
    }
}
