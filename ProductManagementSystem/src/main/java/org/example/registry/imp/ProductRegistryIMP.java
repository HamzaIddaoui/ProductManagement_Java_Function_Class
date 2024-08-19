package org.example.registry.imp;

import org.example.domain.Product;
import org.example.registry.ProductRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRegistryIMP implements ProductRegistry {
    private final Map<Long, Product> products;
    private static ProductRegistry instance = null;

    private ProductRegistryIMP() {
        products = new HashMap<>();
    }

    public ProductRegistry Instance(){
        if(instance == null){
            instance = new ProductRegistryIMP();
        }
        return instance;
    }
    @Override
    public List<Product> findAll() {
        return List.copyOf(products.values());
    }

    @Override
    public Product find(Long id) {
        return products.get(id);
    }

    @Override
    public void add(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product delete(Long id) {
        return products.remove(id);
    }

    @Override
    public void update(Product updatedProduct, Product unmodifiedProduct) {

    }
}
