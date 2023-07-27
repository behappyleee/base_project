package com.sample.data.example.domain;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String street;

    // A Customer on the other hand doesn't know anything about his Address.
    @ManyToOne
    private Customer customer;

}
