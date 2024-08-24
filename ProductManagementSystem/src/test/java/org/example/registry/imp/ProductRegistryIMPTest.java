package org.example.registry.imp;

import org.example.domain.Price;
import org.example.domain.Product;
import org.example.registry.ProductRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class ProductRegistryIMPTest {
    static ProductRegistry productRegistry = ProductRegistryIMP.Instance();

    @BeforeEach
    void setup() {
        Product product = new Product(1L, "productname", "description", new Price(20));
        Product product1 = new Product(2L, "productname", "description", new Price(20));
        Product product2 = new Product(3L, "productname", "description", new Price(20));

        productRegistry.addAll(List.of(product, product1, product2));
    }

    @Test
    void should_return_all_products() {
        Assertions.assertEquals(3, productRegistry.findAll().size());
    }

    @Test
    void should_return_product_by_id() {
        Optional<Product> product1 = productRegistry.find(1L);

        Assertions.assertTrue(product1.isPresent());
    }

    @Test
    void should_delete_product_by_id() {
        productRegistry.delete(1L);

        Assertions.assertTrue(productRegistry.find(1L).isEmpty());
    }

    @Test
    void should_update_product_by_id() {
        Optional<Product> updatedProduct = productRegistry.find(1L);

        updatedProduct.map(product1 -> {
            productRegistry.update(product1,
                    Product.builder()
                            .name("updatedName")
                            .description(product1.getDescription())
                            .price(new Price(product1.price()))
                            .build());
            return product1;
        }).orElseThrow();

        Assertions.assertEquals("updatedName", productRegistry.find(1L).get().getName());
    }

}