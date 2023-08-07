package com.test.springboot_test.domain;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringSimpleArgumentConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentAccessException {
        return String.valueOf(source);
    }

}
