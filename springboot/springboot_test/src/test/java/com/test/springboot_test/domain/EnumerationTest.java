package com.test.springboot_test.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnumerationTest {

    // EnumTest
    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    public void cehckEnumSourceValue(ChronoUnit unit) {
        assertNotNull(unit);
    }

    @ParameterizedTest
    @EnumSource(names = {"DAYS", "HOURS"})
    public void checkEnumSoureNames(ChronoUnit unit) {
        assertNotNull(unit);
    }

}
