package com.sample.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {

    private String name;
    private String teacher;
    private int grade;
    private String school;

}
