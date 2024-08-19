package org.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



class ProductTest {

    @ParameterizedTest
    @CsvSource({
            "1,testProductName,testProductDescription,20",
            "2,testProductName1,testProductDescription1,30",
            "3,testProductName2,testProductDescription2,50",
    })
    void should_create_product(Long id, String name,String description, double price){
        Product product = new Product(id, name, description, new Price(price));

        Assertions.assertEquals(id, product.getId());
        Assertions.assertEquals(name, product.getName());
        Assertions.assertEquals(description, product.getDescription());
        Assertions.assertEquals(price, product.price());
    }
}