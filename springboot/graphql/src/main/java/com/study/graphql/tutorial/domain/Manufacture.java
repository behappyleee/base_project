package com.study.graphql.tutorial.domain;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Manufacture {

    // This POJO maps to the product type and Manufacture maps to the manufacture object defined
    // in our GraphQL schema.

    // Manufacture object defined in our GraphQL schema.

    private String id;
    private String name;
    private String address;
}