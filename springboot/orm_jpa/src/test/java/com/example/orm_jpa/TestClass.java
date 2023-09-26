package com.example.orm_jpa;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClass {

    Logger logger = LoggerFactory.getLogger(TestClass.class);

    @Test
    public void debugRunTest() {
        // Debugging 동작 방식 Test

        logger.debug("THIS LOGGER 1");

        System.out.println("1");


        logger.debug("THIS LOGGER 2");
        logger.debug("THIS LOGGER 3");

        System.out.println("2");

        logger.debug("THIS LOGGER 4");
        logger.debug("THIS LOGGER 5");
        logger.debug("THIS LOGGER 6");

        System.out.println("3");

        System.out.println("4");

        System.out.println("5");

        logger.debug("THIS LOGGER 77");

    }


}
