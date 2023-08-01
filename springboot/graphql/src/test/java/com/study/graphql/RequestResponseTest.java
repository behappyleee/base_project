package com.study.graphql;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
public class RequestResponseTest {

    Logger logger = LoggerFactory.getLogger(RequestResponseTest.class);

    // GraphQL Request / Response
    @Test
    public void requestTest() {
        WebTestClient webClient = WebTestClient.bindToServer().build();

        System.out.println("WEB CLIENT TO STRING : " + webClient.toString());

        logger.debug("TEST : {} " , webClient.toString());
        logger.debug("WEBCLIENT : {} ", webClient.toString());

        webClient.get()
                .uri("").exchange().toString();


    }



}
