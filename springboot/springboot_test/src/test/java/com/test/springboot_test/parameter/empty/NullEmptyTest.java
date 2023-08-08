package com.test.springboot_test.parameter.empty;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NullEmptyTest {

    @ParameterizedTest
    @NullSource
    public void checkNull(String value) {
        assertEquals(null, value);
    }

    @ParameterizedTest
    @EmptySource
    public void checkEmpty(String value) {
        assertEquals("", value);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void checkNullAndEmpty(String value) {

        System.out.println("VALUE LENGTH : " + value.length());

        assertTrue(value == null || value.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    public void checkNullEmptyAndBlank(String value) {
        assertTrue(value == null || value.isEmpty());
    }


}
