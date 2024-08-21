package org.example.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }
}
