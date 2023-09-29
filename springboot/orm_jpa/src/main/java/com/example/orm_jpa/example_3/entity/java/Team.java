package com.example.orm_jpa.example_3.entity.java;

import jakarta.persistence.Entity;

public class Team {

    // 순수 Java 로 연관 관계 표현

    private String id;

    private String name;

    public Team() {}

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
