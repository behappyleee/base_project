package com.study.graphql.tutorial.controller;

import com.study.graphql.tutorial.domain.Person;
import com.study.graphql.tutorial.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonService personService;

    @QueryMapping
    public Person getPersonById(String id) {
        return personService.getPersonById(id);
    }




}
