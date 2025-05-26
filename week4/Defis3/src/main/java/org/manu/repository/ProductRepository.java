package org.manu.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.manu.models.Product;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>(); // Une fausse "base de données" en mémoire

    public ProductRepository() {
        // Ajoute des produits de test au démarrage
        products.add(new Product(1L, "Laptop", 1200.0));
        products.add(new Product(2L, "Mouse", 25.0));
        products.add(new Product(3L, "Keyboard", 75.0));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products); // Retourne une copie pour éviter les modifications externes
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}