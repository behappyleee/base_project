package com.test.springboot_test.parameter.conversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArgumentConversionTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4})
    public void checkWideningArgumentConversion(long number) {
        assertEquals(0, number % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = "DAYS")
    public void checkImplicitArgumentConversion(ChronoUnit argument) {
        assertNotNull(argument.name());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Name1", "Name2"})
    public void checkImplicitFallbackArgumentConversion(Person person) {
        assertNotNull(person.getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {100})
    public void checkExplicitArgumentConversion(@ConvertWith(StringSimpleArgumentConverter.class) String argument) {
        assertEquals("100", argument);
    }

}
