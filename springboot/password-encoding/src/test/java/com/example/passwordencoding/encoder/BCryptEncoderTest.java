package com.example.passwordencoding.encoder;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {

    private final int DEFAULT_ENCODE_LENTH = 10;

    @Test
    public void bCryptEncodeTest() {
        // BCrypt Length 필요
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(DEFAULT_ENCODE_LENTH);

    }


}
