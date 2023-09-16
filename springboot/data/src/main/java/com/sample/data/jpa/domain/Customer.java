package com.sample.data.jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// @Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

}
