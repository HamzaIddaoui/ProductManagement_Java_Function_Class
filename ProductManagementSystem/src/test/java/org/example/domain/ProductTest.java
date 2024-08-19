package org.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void should_create_product(){
        Product product = new Product(1L, "testProductName", "testProductDescription", new Price(20));

        Assertions.assertEquals(1L, product.getId());
        Assertions.assertEquals("testProductName", product.getName());
        Assertions.assertEquals("testProductDescription", product.getDescription());
        Assertions.assertEquals(20, product.price());
    }
}