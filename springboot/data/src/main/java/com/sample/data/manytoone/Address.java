package com.sample.data.manytoone;

import jakarta.persistence.*;


@Entity
public class Address {

    // When both sides of the association know each other, we have a bidirectional association, which looks like this in JPA
    // From the address-side (@MnayToOne - side) of the relationship, this will work

    // From the customer-side however a PUT request like the one contains one or more links to an Address will not work.

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String street;

    // Address 기준 으로 고객 들이 여러개 Address 데이터를 가질 수 있음 - ManyToOne
    @ManyToOne
    private Customer customer;

}
