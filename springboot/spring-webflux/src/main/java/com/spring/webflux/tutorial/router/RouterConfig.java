package com.spring.webflux.tutorial.router;

//import com.spring.webflux.tutorial.handler.UserHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import static org.springframework.web.servlet.function.RequestPredicates.*;
//import static org.springframework.web.servlet.function.RouterFunctions.route;

import com.spring.webflux.tutorial.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    // will define the router function Router Functions usually evaluate the request and choose the appropriate handler function.
    // They server as an alternate to the @RequestMapping annotation. So we will define this RotherFunction and annotate it with @Bean
    // within a @Configuration class to inject it into the Spring Application Context

    // Spring WebFlux 를 사용하기 위하여서는 Controller 에서 직접 지정을 해주거나 UserHandler 를 사용 하여 수행하는 방식 중 선택

    @Bean
    RouterFunction <ServerResponse> routes(UserHandler handler) {
        return route(GET("/handler/users").and(accept(MediaType.APPLICATION_JSON)), handler::getAllUsers)
                .andRoute(GET("/handler/users/{userId}").and(contentType(MediaType.APPLICATION_JSON)), handler::getUserById)
                .andRoute(POST("/handler/users").and(accept(MediaType.APPLICATION_JSON)), handler::create)
                .andRoute(PUT("/handler/users/{userId}").and(contentType(MediaType.APPLICATION_JSON)), handler::updateUserById)
                .andRoute(DELETE("/handler/users/{userId}").and(accept(MediaType.APPLICATION_JSON)), handler::deleteUserById);
    }

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        Flux.just("X", "Y", "Z")
                .log()  // Log 사용 시 모두 기록이 됨 Console log 에
                .subscribe(strList::add);


    }

}
