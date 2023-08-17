package com.example.passwordencoding.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class BCryptExample {

    private final int DEFAULT_BCRYPT_LENGTH = 10;

    public String encode(String plainPassword) {
        // Length 기본 Default 10
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(DEFAULT_BCRYPT_LENGTH, new SecureRandom());

        return bCryptPasswordEncoder.encode(plainPassword);
    }

}
