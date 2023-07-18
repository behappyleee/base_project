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

        // Reactive Stream 에 친숙하지 않은 대부분 개발자 들은 Flux 를 사용할 것이다, 하지만 조금 더 시간을 투자해 보면
        // 내부적으로 Flux API 는 도움이 되지 않는다. Reactive Ecosystem 에 조금더 투자를 해보면
        // Asynchronous Chain 들이 조금더 자연스럽게 느껴질 것이다.
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
