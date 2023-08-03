package com.sample.rest.controller;

import com.sample.rest.domain.Person;
import com.sample.rest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestControllerTest {

    private final PersonService personService;

    Logger logger = LoggerFactory.getLogger(RestControllerTest.class);

    // Exception Test
    @RequestMapping("/exceptionTest")
    public List<Person> exceptionTest() {
        logger.debug("THIS IS TEST LOGGER TEST !!!!");

        return personService.getPersonListData();
    }

}
