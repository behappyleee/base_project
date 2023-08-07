package com.test.springboot_test.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BasicTest {

    private final Logger logger = LoggerFactory.getLogger(BasicTest.class);

    // 받는 Parameter Test
    @ParameterizedTest
    @ValueSource(ints = {2, 4})
    public void basicTest_1(long number) {
        System.out.println("BASIC_TEST _! PARAMETER NUMBER : " + number);
        // Parameter 로 받은 수 가 짝수 인지 판별
        assertEquals(0, number % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = "DAYS")
    public void checkImplicitArgumentConversion(ChronoUnit argument) {
        // Parameter Name 데이터 가져옴 !!
        assertNotNull(argument.name());
    }



}
