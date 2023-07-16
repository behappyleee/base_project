package com.spring.webflux.request.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
public class RequestPostController {

    Logger logger = LoggerFactory.getLogger(RequestPostController.class);

    public static void main(String[] args) throws URISyntaxException {

        // WebClient Instance 생성
        WebClient webClient = WebClient.create();

        // POST Request
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();

        bodyValues.add("key", "value");
        bodyValues.add("another-key", "another-value");

        // WebClient 는 Header 와 Method Type 들을 사용할 수 있게 해 줌
        //

        String response = webClient.post()
                .uri(new URI("https://httpbin.org/post"))
                .header("Authorization", "Bearer MY_SECRET_TOKNE")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }

}
