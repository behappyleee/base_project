package com.test.springwebflux.jwt.domain;

import lombok.Getter;

@Getter
public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }
}
