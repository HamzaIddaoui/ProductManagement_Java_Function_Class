package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor @Builder
public class Product {
    private Long id;
    private String name;
    private String description;
}
