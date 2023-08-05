package com.sample.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
public class WebClientTest {

    @Test
    public void WebClientTest() {
//        WebTestClient webClient = WebTestClient
//                .bindToServer()
//                .baseUrl("https://api.github.com/users/hadley/orgs")
//                .build();
//        webClient.get();

        // WebTestClient webClient = WebTestClient.bindToServer().build();

        WebTestClient webClient = WebTestClient.bindToServer().baseUrl("https://api.github.com").build();
        WebTestClient.ResponseSpec res = webClient
                    .get()
                    .uri("/users/hadley/orgs")
                    .exchange()
                    .expectStatus().isOk()
                    .expectHeader().contentType(MediaType.APPLICATION_JSON);

        System.out.println("RES DATA CHECK  : " + res.toString());

    }


}
