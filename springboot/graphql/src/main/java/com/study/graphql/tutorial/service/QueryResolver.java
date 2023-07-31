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
    // Resolver 란 GrpahQL 의 여러가지 타입 중 Query, Mutation, Subscription 과 같은 타입이 실제로 일을 하는 부분
    // 선언 된 타입의 정의 부분, 그래서 스키마를 정의하면 그 스키마 필드에 사용되는 함수의 실제 행동을 Resolver 에서 정의

    // defined the QueryResolver class as a Service class to resolve the root Query type in our GraphQL schema
    // In our example app, this service class is injected with a ProductRepository object to fetch product data from H2

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
