package org.example.registry.imp;

import org.example.domain.Price;
import org.example.domain.Product;
import org.example.registry.ProductRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRegistryIMPTest {

    @Test
    void should_return_all_products(){
        Product product = new Product(1L, "productname", "description", new Price(20));
        Product product1 = new Product(2L, "productname", "description", new Price(20));
        Product product2 = new Product(3L, "productname", "description", new Price(20));

        ProductRegistry productRegistry = ProductRegistryIMP.Instance();

        productRegistry.addAll(List.of(product, product1, product2));

        Assertions.assertEquals(3, productRegistry.findAll().size());
    }

}