package com.spring.webflux.tutorial.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow;

public class PublisherTest {

    public static void main(String[] args) {
        // Webflux Publisher
        // Flow.Publisher

        // Mono : A Publisher taht emits 0 or 1 element.
        Mono<String> mono = Mono.just("john");
        Mono<Object> monoEmpty = Mono.empty();
        Mono<Object> monoError = Mono.error(new Exception());

        // Flux : A Publisher that emits 0 to N elements
        Flux<Integer> flux = Flux.just(1,2,3,4);
        Flux<String> fluxString = Flux.fromArray(new String[]{"A", "B", "C", "D", "E", "F"});
        Flux<String> fluxIterable = Flux.fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"));

        // To Stream data and call Subscribe Method
        List<String> dataStream = new ArrayList<>();
        Flux.just("X", "Y", "Z")
                .log()
                .subscribe(dataStream::add);

        // Once the stream of data is created, it needs to be subscribed to so it starts emitting elements.
        // Reactor Also provides operators to work with Mono and Flux Objects. Some of them are.
        // Map - It is used to transform from one element to another.
        // FlatMap - It flatters a list of Publishers to the values that these publishers emit. The transfromation is asynchronous.
        // DelayElements - It delays the publishing of each element by a defined duration.
        // Concat - It is used to combine the elements emitted by a Publisher by keeping the sequence of the publishers intact.
        // Merge - It is used to combine the publishers without keeping its sequence.
        // Zip - It is used to combine two or more publishers by waiting on all the sources to emit one element and combining these elements into an output value.





    }

}
