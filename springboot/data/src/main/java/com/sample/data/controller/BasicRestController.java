package com.sample.data.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

    private static final Logger logger = LoggerFactory.getLogger(BasicRestController.class);

    @GetMapping("/testJpa")
    public String jpaTest() {
        logger.debug("TEST REST CONTROLLER ~~");


        return "JpaTest !";
    }

}
