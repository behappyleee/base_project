package com.sample.rest.service;

import com.sample.rest.domain.Gender;
import com.sample.rest.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person getPersonData() {
        return new Person("Name Test", 3, "Seoul", Gender.MALE);
    }

}
