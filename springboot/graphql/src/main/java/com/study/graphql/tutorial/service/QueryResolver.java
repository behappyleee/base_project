package com.study.graphql.tutorial.service;

import com.study.graphql.tutorial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO
// GraphQL Resolver 구현 하기 !!!

// TODO
// GraphQL Resolver 구현체 찾기 !!!
// TODO !!!

@Service
public class QueryResolver {

    private ProductRepository productRepository;

    @Autowired
    public QueryResolver(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
