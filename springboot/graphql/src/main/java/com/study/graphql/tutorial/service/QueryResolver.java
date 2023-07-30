package com.study.graphql.tutorial.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.study.graphql.tutorial.domain.Product;
import com.study.graphql.tutorial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// defined the QueryResolver 클래스 as a Service Class to resolve the root Query type in GraphQL Schema, In our example app
// this service class in injected with a ProductRepository object to fetch product data from H2 DataBase.
@Service
public class QueryResolver implements GraphQLQueryResolver {

    private ProductRepository productRepository;

    @Autowired
    public QueryResolver(final ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    public List<Product> getMyRecentPurchases(final Integer count
            , String customerID) {

        List<Product> products = productRepository.getRecentPurchases(count);

        return products;
    }

    public List<Product> getLastVisitedProducts(
            final Integer count, final String customerID) {
        List<Product> products = productRepository
                .getLastVisitedPurchases(count);
        return products;
    }

    public List<Product> getProductsByCategory(
            final String category) {
        List<Product> products = productRepository
                .getProductsByCategory(category);
        return products;
    }

}
