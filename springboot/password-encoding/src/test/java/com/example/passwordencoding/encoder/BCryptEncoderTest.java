package com.example.passwordencoding.encoder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class BCryptEncoderTest {

    // Note that in contrast to simple hash algorithms like SHA-256 or MD5,
    // the output of bcrypt contains meta-information about the version of the algorithm, work factor,
    // and salt. We don’t need to save this information separately.

    private final int DEFAULT_ENCODE_LENTH = 10;
    private final String INPUT_PASSWORD = "abcABC1234$";    // TEST INPUT Password Password
    private final String INPUT_PASSWORD_2 = "testPasswordCheck#";    // TEST INPUT Password Password

    @Test
    public void bCryptEncodeTest() {
        // BCrypt Length 필요
        // SecureRandom => recommended to use a SecureRandom as a salt generator, because it provides a cryptographically strong random number.
        BCryptPasswordEncoder bCryptPassword = new BCryptPasswordEncoder(DEFAULT_ENCODE_LENTH, new SecureRandom());

        System.out.println("RAW PASSWORD : " + INPUT_PASSWORD);

        String encodedPassword = bCryptPassword.encode(INPUT_PASSWORD);

        System.out.println("ENCODED PASSWORD : " + encodedPassword);

        boolean isMatchPassword = bCryptPassword.matches(INPUT_PASSWORD, encodedPassword);

        System.out.println("IS MATCH PASSWORD : " + isMatchPassword);

        boolean isNotMatchPassword = bCryptPassword.matches(INPUT_PASSWORD_2, encodedPassword);

        System.out.println("IS MATCH PASSWORD (WRONG) : " + isNotMatchPassword);

    }


}


