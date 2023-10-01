package com.example.orm_jpa.example_10.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private String id;

    @Column(name = "name")
    private String username;

    @Column(name = "age")
    private int age;

}
