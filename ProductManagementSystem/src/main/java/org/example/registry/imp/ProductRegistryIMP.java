package org.example.registry.imp;

import org.example.domain.Product;
import org.example.identitymap.ProductsIdentityMap;
import org.example.registry.ProductRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductRegistryIMP implements ProductRegistry {
    private final ProductsIdentityMap productsIdentityMap;
    private static ProductRegistry instance = null;

    private ProductRegistryIMP() {
        this.productsIdentityMap = ProductsIdentityMap.getInstance();
    }

    public static ProductRegistry Instance(){
        if(instance == null){
            instance = new ProductRegistryIMP();
        }
        return instance;
    }
    @Override
    public List<Product> findAll() {
        return productsIdentityMap.findAll();
    }

    @Override
    public Optional<Product> find(Long id) {
        return productsIdentityMap.find(id);
    }

    @Override
    public void add(Product product) {
        productsIdentityMap.put(product);
    }

    @Override
    public void addAll(List<Product> inputProducts) {productsIdentityMap.putAll(inputProducts);}

    @Override
    public Product delete(Long id) {
        return productsIdentityMap.delete(id);
    }

    @Override
    public void update(Product updatedProduct, Product unmodifiedProduct) {
        productsIdentityMap.update(updatedProduct, unmodifiedProduct);
    }
}
