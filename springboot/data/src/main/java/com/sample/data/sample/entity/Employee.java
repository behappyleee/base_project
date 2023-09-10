package com.sample.data.sample.entity;

import com.sample.data.sample.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "employees")
@Getter
@Setter
public class Employee {

    @Id
    int emp_no;

    Date birth_date;

    String firstName;

    String lastName;

    Gender genger;

    Date hire_date;

}
