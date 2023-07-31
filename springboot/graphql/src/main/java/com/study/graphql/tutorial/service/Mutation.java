package com.study.graphql.tutorial.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.study.graphql.tutorial.domain.Product;

// Mutation class implements GraphQLMutationResolver and contains a method addRecentProduct
// which maps to the field in the Mutation root object type.
public class Mutation implements GraphQLMutationResolver {

    // Similar to the resolver for Query object types, let us add a resolver for the Mutation
    // root object type.

    public Product addRecentProduct(
            final String title,
            final String description,
            final String category) {

        return Product.builder()
                .title("television")
                .category("electronic")
                .build();
    }
}
