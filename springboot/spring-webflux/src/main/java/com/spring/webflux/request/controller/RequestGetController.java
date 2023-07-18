package com.spring.webflux.request.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@RequestMapping("/api")
public class RequestGetController {

    @GetMapping("/helloFlux")
    public String helloWebFlux() {
        return "Hello Spring Web Flux !!";
    }

    // TODO
    // WebFlux 학습 하기 Web Request !!!
    // https://reflectoring.io/spring-webclient/

    // Spring WebFlux 는 Spring Web MVC APIs 들과 같이 사용할 수 있도록 Designed 됨
    // Spring 5 부터 RestTemplate 대신에 WebClient 를 대신 사용
    // Non-Blocking Method 를 추가하기 위하여서는 Spring-Webflux 를 사용하여야 한다.

    // Spring Web Flux 를 사용하기 위한 방법
    // Spring Web Flux Dependency 를 추가
    // spring-starter-webflux 하나만 추가하거나 spring-webflux 와 reactor-netty 2개를 추가
    
    // Flux
    // Flux represents a stream of elements. It's a sequence that will asynchronous emit any number of items.
    // In reactive programming this is our bread-and-butter. A Flux is a stream that we can transform, buffer into a list
    // reduce down to a single value, concentrate and merge with other Fluxes, or block on to wait for a value.

    // Mono
    // A Mono is a specific but very common type of Flux: a Flux that will asynchronously emit either 0 or 1 results before it completes.



    public static void main(String[] args) {
        // 1. Create WebClient Instance
        WebClient client = WebClient.create();

        // 2. define a request using the WebClient instance, specifying the request method (GET)
        // and URI

        // 3. finish configuring the request, and obtain a ResponseSpec.

        // retrive() client automatically checks the status code for us, providing a sensible default by
        // throwing an error for any 4XX or 5XX responses.
        WebClient.ResponseSpec responseSpec = client.get()
                .uri("http://example.com")
                .retrieve();

        // Once we've made a reqeust, we usually want to read the contents of the response.
        // retrieve() to get a ResponseSpec for a request. This is an Asynchronous operation.

        // To Read the response body, we need to get a Mono(an async future value) for the contents of the response.
        // We then need to unwrap that somehow, to trigger the request and get the response body content itself, once it's available.

        // There are a few different ways to unwrap an asynchronous value, To start with, we'll use the simplest
        // traditional option, by blocking to wait for the data to arrive.

        // This gives us a String containing the raw body of the response.
        String responseBody = responseSpec.bodyToMono(String.class).block();



    }

}
