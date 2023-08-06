package com.study.graphql.tutorial.controller;


import com.study.graphql.tutorial.domain.Person;
import com.study.graphql.tutorial.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GraphqlRestController {

    private final PersonService personService;

    @GetMapping("/dataTest")
    public ResponseEntity<Person> test() {

        return ResponseEntity.ok(personService.getPersonData());
        // return null;
    }

}
