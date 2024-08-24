package org.example.identitymap;

import org.example.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
}
