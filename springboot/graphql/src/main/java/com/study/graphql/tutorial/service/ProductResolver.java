package com.study.graphql.tutorial.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.study.graphql.tutorial.domain.Manufacture;
import com.study.graphql.tutorial.domain.Product;
import com.study.graphql.tutorial.repository.ManufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductResolver implements GraphQLResolver <Product> {

    // Multiple resolver components convert the GraphQL request received from API Consumers
    // and invoke operations to fetch data from applicable data sources. For each type, we define a resolver.

    // The resolver classes need to implement GraphQLQueryResolver for the Query object and GraphQLMutationResolver
    // for the Mutation object. Query and Mutation are the root GraphQL objects

    // The GraphQL library will automatically call this resolver for each Product to resolve its madeby
    // field with a Manufacturer object. This happens only if the consumer has requested the madeby field, of course


    private ManufactureRepository manufactureRepository;

    @Autowired
    public ProductResolver(ManufactureRepository manufactureRepository) {
        super();
        this.manufactureRepository = manufactureRepository;
    }

    public Manufacture getMadeBy(final Product product) {
        return manufactureRepository
                .getManufacturerById(product.getManufacturerID());
    }

}
