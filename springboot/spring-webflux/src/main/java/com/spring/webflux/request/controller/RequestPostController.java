package com.spring.webflux.request.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestPostController {

    Logger logger = LoggerFactory.getLogger(RequestPostController.class);

    public static void main(String[] args) {

        // POST Request
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();

        bodyValues.add("key", "value");
        bodyValues.add("another-key", "another-value");

    }

}
