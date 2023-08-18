package com.example.passwordencoding.encoder;

import org.h2.security.SHA256;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class Pbkdf2PasswordEncoderTest {

    // PBKDF2 algorithm was not designed for password encoding but for key derivation from a password
    // Key derivation is usually needed when we want to encrypt some data with a password,
    // but the password is not strong enough to be used as an encryption key.

    // Pbkdf2PasswordEncoder runs the hash algorithm over the plain password many times. It generates a salt, too.
    // We can define how long the output can be and additionally use a secret called pepper to make the password encoding more secure.

    // The pepper should be kept as a secret.
    private final String INPUT_PASSWORD = "thisistestpasswd123";
    private final String DEFAULT_PEPEER = "pepper";   // use a secret called pepper to make the password encoding more secure.
    private final int DEFAULT_ITERATIONS = 200000;  // number of hash iteration
    private final int DEFAULT_HASHWIDTH= 256;      // hash width in bits

    @Test
    public void pbkdf2PasswordEncoderTest() {
        Pbkdf2PasswordEncoder pbkdf2 = new Pbkdf2PasswordEncoder(DEFAULT_PEPEER, DEFAULT_ITERATIONS
                , DEFAULT_HASHWIDTH, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);

        System.out.println("RAW PASSWORD : " + INPUT_PASSWORD);

        String encodedPassword = pbkdf2.encode(INPUT_PASSWORD);

        System.out.println("ENCODED PASSWORD : " + encodedPassword);

        boolean isMatchPassword = pbkdf2.matches(INPUT_PASSWORD, encodedPassword);

        System.out.println("IS MATCH PASSWORD : " + isMatchPassword);
    }


}
