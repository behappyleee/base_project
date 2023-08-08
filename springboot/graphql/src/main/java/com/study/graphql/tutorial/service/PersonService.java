package com.study.graphql.tutorial.service;

import com.study.graphql.tutorial.domain.Person;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {


    Logger logger = LoggerFactory.getLogger(PersonService.class);

    // REST API 를 좋은 방식으로 구현하기 위하여서는
    public Person getPersonData() {
        return new Person("PersonID", "PersonName", "PersonAddress", 24);
    }

    public Person getPersonById(String id) {
        // TODO
        // Person 만 가져올 수 있도록 구현 하여 보기 !!!
        return null;
    }


}
