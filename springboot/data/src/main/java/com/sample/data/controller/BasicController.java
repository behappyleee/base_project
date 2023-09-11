package com.sample.data.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    private static Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/hello")
    public String hello() {
        logger.debug("THIS IS BASIC CONTROLLER TEST !");

        return "hello";
    }


}
