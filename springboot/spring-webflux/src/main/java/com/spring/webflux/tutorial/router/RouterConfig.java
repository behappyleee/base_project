package com.spring.webflux.tutorial.router;

import com.spring.webflux.tutorial.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.servlet.function.RequestPredicates.*;
import static org.springframework.web.servlet.function.RouterFunctions.route;


@Configuration
public class RouterConfig {

    @Bean
    RouterFunction <ServerResponse> routes(UserHandler handler) {
        // TODO
        // 확인 필요
        // 왜 geAllUsers 에러 발생 하는 지 .... ???
        return route(GET("/handler/users").and(accept(MediaType.APPLICATION_JSON)), handler::getAllUsers)
                .andRoute(GET("/handler/users/{userId}").and(contentType(MediaType.APPLICATION_JSON)), handler::getUserById)
                .andRoute(POST("/handler/users").and(accept(MediaType.APPLICATION_JSON)), handler::create)
                .andRoute(PUT("/handler/users/{userId}").and(contentType(MediaType.APPLICATION_JSON)), handler::updateUserById)
                .andRoute(DELETE("/handler/users/{userId}").and(accept(MediaType.APPLICATION_JSON)), handler::deleteUserById);
    }
}
