package com.study.graphql.tutorial.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private String rating;
    private String category;

    @OneToOne
    @JoinColumn(name="manufacture_name")
    private Manufacture madeBy;

}
