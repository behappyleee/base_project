package com.sample.rest.controller;

import com.sample.rest.domain.Person;
import com.sample.rest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService personService;

    @GetMapping("/getData")
    public Person getPersonData() {
        return personService.getPersonData();
    }


}
