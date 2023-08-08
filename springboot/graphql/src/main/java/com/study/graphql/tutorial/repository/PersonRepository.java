package com.study.graphql.tutorial.repository;

import com.study.graphql.tutorial.domain.Manufacture;
import com.study.graphql.tutorial.domain.Person;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepository {

    Logger logger = LoggerFactory.getLogger(PersonRepository.class);

    // SpringBoot 실행 시 Person Dummy Data 생성
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(final DataSource dataSource) {
        super();
        this.dataSource = dataSource;
        this.jdbcTemplate =  new JdbcTemplate(dataSource);
    }

    @PostConstruct
    private void initialize() {
        insertPersons(getPersons());
    }

    public List<Person> getPersons() {
        Person[] persons = new Person[] {
                Person.builder().id("1").address("Seoul").name("Kim").age(24).build(),
                Person.builder().id("2").address("Suwon").name("Lee").age(27).build(),
                Person.builder().id("3").address("Hwaseong").name("Park").age(32).build(),
        };
        return Arrays.asList(persons);
    }

    public void insertPersons(final List<Person> persons) {
        String sql = "INSERT INTO PERSON " + "(id, name, address, age) VALUES (?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Person person = persons.get(i);
                ps.setString(1, person.getId());
                ps.setString(2, person.getName());
                ps.setString(3, person.getAddress());
                ps.setInt(4, person.getAge());
            }
            @Override
            public int getBatchSize() {
                return persons.size();
            }
        });
    }

}
