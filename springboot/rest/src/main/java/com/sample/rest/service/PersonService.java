package com.sample.rest.service;

import com.sample.rest.domain.Gender;
import com.sample.rest.domain.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {

    public Person getPersonData() {
        return new Person("Name Test", 3, "Seoul", Gender.MALE);
    }

    public List<Person> getPersonListData() {
        Person p1 = new Person("Name Test", 3, "Seoul", Gender.MALE);
        Person p2 = new Person("Name Second", 5, "Pusan", Gender.FEMALE);

        // TODO
        // REST API Exception Test 하기 !!!!
        if(true) {
            throw new RuntimeException("Please Set Proper Parameter");
        }

        return Arrays.asList(p1, p2);
    }



}
