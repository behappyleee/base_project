package com.study.graphql.tutorial.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.study.graphql.tutorial.domain.Product;
import com.study.graphql.tutorial.repository.ManufactureRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductResolver implements GraphQLResolver <Product> {

    private ManufactureRepository manufactureRepository;


}
