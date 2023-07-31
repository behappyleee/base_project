package com.study.graphql.tutorial.domain;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product {
    private String id;
    private String title;
    private String description;
    private String rating;
    private String category;
    private Manufacture madeBy;
    private String manufacturerID;

}

