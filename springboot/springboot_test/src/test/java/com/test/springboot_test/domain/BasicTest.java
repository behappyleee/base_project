package com.test.springboot_test.domain;

import com.test.springboot_test.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
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

    // Parameter Test 1
    @ParameterizedTest
    @ValueSource(ints = {2, 4})
    public void basicTest_1(long number) {
        System.out.println("BASIC_TEST _! PARAMETER NUMBER : " + number);
        // Parameter 로 받은 수 가 짝수 인지 판별
        assertEquals(0, number % 2);
    }

    // Parameter Test 2
    @ParameterizedTest
    @ValueSource(strings = "DAYS")
    public void checkImplicitArgumentConversion(ChronoUnit argument) {
        // Parameter Name 데이터 가져옴 !!
        assertNotNull(argument.name());
    }

    // Parameter Test 3
    @ParameterizedTest
    @ValueSource(strings = {"Name1", "Name2"})
    public void checkImplicitArgumentConversion(Person person) {

        System.out.println("PERSON GET NAME DATA CHECK : " + person.getName());

        assertNotNull(person.getName());
    }

    // Parameter Test 4
    @ParameterizedTest
    @ValueSource(ints = { 100 })
    public void checkExplicitArgumentConversion(@ConvertWith(StringSimpleArgumentConverter.class) String argument) {
        assertEquals("100", argument);
    }






}
