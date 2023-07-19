package com.handling.exception.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Product {

    @Id
    private String id;

    private String name;

    private Double price;

    private LocalDateTime manufacturingDate;


    private Double weight;

    @Embedded
    private Dimension dimension;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Embeddable
    @Getter
    @Setter
    public static class Dimension {
        private Double height;

        private Double width;
    }

}
