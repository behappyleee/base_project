package com.example.passwordencoding.encoder;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class Argon2PasswordEncoderTest {

    // Argon2 is the winner of Password Hashing Competition in 2015. This algorithm, too, allows us
    // to tune CPU and memory costs. The Argon2 encoder saves all the parameters in the result string.
    // If we want to use this password encoder, we’ll have to import the BouncyCastle crypto library.

    private final String INPUT_PASSWORD = "inputTestPasswordCheck!!";

    private int saltLength = 16; // salt length in bytes
    private int hashLength = 32; // hash length in bytes
    private int parallelism = 1; // currently not supported by Spring Security
    private int memory = 4096;   // memory costs
    private int iterations = 3;

    @Test
    public void argon2PasswordEncodingTest() {
        Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder(
                saltLength,
                hashLength,
                parallelism,
                memory,
                iterations);

        System.out.println("RAW PASSWORD : " + INPUT_PASSWORD);

        String encodePassword = argon2PasswordEncoder.encode(INPUT_PASSWORD);

        System.out.println("ENCODED PASSWORD : " + encodePassword);

        boolean isMatchPassword = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8().matches(INPUT_PASSWORD, encodePassword);

        System.out.println("IS MATCH PASSWORD : " + isMatchPassword);

    }

}
