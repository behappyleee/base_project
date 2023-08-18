package com.example.passwordencoding.encoder;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class SCryptPasswordEncoderTest {

    private final String INPUT_PASSWORD = "inputPasswordTest";

    private int cpuCost = (int) Math.pow(2, 14); // factor to increase CPU costs
    private int memoryCost = 8;      // increases memory usage
    private int parallelization = 1; // currently not supported by Spring Security
    private int keyLength = 32;      // key length in bytes
    private int saltLength = 64;     // salt length in bytes

    @Test
    public void sCryptPasswordEncoderTest() {
        SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder(
            cpuCost, memoryCost, parallelization, keyLength, saltLength
        );

        System.out.println("RAW PASSWORD : " + INPUT_PASSWORD);

        String encodedPassword = sCryptPasswordEncoder.encode(INPUT_PASSWORD);

        System.out.println("ENCODED PASSWORD : " + encodedPassword);

        boolean isMatchPassword = sCryptPasswordEncoder.matches(INPUT_PASSWORD, encodedPassword);

        System.out.println("IS MATCH PASSWORD : " + isMatchPassword);

    }

}
