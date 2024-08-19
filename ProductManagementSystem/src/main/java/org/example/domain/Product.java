package org.example.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor @Builder @Getter
public class Product {
    private Long id;
    private String name;
    private String description;
    @Getter(AccessLevel.PRIVATE)
    private Price price;

    public double price() {
        return price.getPrice();
    }
}
