package org.example.registry;

import org.example.domain.Product;

import java.util.List;

public interface ProductRegistry {
    List<Product> findAll();
    Product find(Long id);
    void add(Product product);
    void addAll(List<Product> inputProducts);
    Product delete(Long id);
    void update(Product updatedProduct, Product unmodifiedProduct);
}
