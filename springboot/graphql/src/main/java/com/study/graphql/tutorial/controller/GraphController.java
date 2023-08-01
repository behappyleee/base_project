package com.study.graphql.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphController {

    @RequestMapping("/graphql/test")
    public String graphqlTest () {

        return "GraphQL Test Check !!";
    }

}
