package com.sample.rest;

import com.sample.rest.domain.Person;
import com.sample.rest.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ObjectDataRestTest {

    Logger logger = LoggerFactory.getLogger(ObjectDataRestTest.class);

    @Autowired
    PersonService personService;

    @Test
    public void getDataTest() {

        logger.info("THIS IS TEST !!");

        Person per1 = personService.getPersonData();

        System.out.println("PERSON 1 : " + per1);
        logger.info("PERSON DATA 1 : {} ", per1);

        Person per2 = personService.getPersonData();

        logger.info("PERSON DATA 2 : {} ", per2);
        System.out.println("PERSON 2 : " + per2);
    }


}



