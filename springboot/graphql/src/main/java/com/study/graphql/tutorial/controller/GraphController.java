package com.study.graphql.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GraphController {

    private final Logger logger = LoggerFactory.getLogger(GraphController.class);

    @GetMapping("/hello")
    public String hello() {
        logger.info("GRAPHQL CONTROLLER HELLO TEST !!");


        return "hello";
    }

}
