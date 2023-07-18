package com.spring.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebHandler;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

@SpringBootTest
public class WebClientTest {

    @Test
    public void webClientTest() {

        // Connect to a read server over HTTP
        WebTestClient client = WebTestClient
                .bindToServer()
                .baseUrl("http://localhost:8080")
                .build();

        // Or connect to a single WebHandler using mock objects:
        WebHandler handler = new WebHandler() {
            @Override
            public Mono<Void> handle(ServerWebExchange exchange) {
                Mono<Void> mono = new Mono<Void>() {
                    @Override
                    public void subscribe(CoreSubscriber<? super Void> actual) {

                    }
                };
                return mono;
            }
        };
        WebTestClient client1= WebTestClient
                .bindToWebHandler(handler)
                .build();

        // Once we've created a WebTestClient, we can define requests just like any other WebClinet.
        // To Send the request and check the result, we call .exchange() and then use the assertion
        // methods available there
        WebTestClient.ResponseSpec rs = client.get().uri("/api/helloFlux")
                        .exchange();

        System.out.println("RS TO STRING : " + rs.toString());

        client.get()
                .uri("/api/helloFlux")   // ex
                .exchange()
                .expectStatus().isNotFound();   // Assertion that this is a 404 response


    }



}
