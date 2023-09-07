package com.sample.data.jpa.manytoone;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Address> addresses;

}
