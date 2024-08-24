package org.example.identitymap;

import org.example.domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductsIdentityMap {
    private Map<Long, Product> productsMap = new HashMap<>();
    private static ProductsIdentityMap instance = null;

    private ProductsIdentityMap(){}

    public static ProductsIdentityMap getInstance() {
        if(instance == null){
            instance = new ProductsIdentityMap();
        }
        return instance;
    }

    public Optional<Product> find(Long id){
        return Optional.ofNullable(productsMap.get(id));
    }

    public List<Product> findAll(){
        return List.copyOf(productsMap.values());
    }

    public void put(Product product){
        productsMap.put(product.getId(), product);
    }

    public void putAll(List<Product> products){
        productsMap.putAll(products.stream().collect(Collectors.toMap(Product::getId, Function.identity())));
    }

    public Product delete(Long id){return productsMap.remove(id);}

    public void update(Product updatedProduct, Product unmodifiedProduct) {
        updatedProduct.update(unmodifiedProduct);
        productsMap.put(updatedProduct.getId(), updatedProduct);
    }
}
