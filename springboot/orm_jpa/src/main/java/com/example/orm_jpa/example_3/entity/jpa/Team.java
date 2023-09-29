package com.example.orm_jpa.example_3.entity.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Team")
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    @OneToMany
    private List <Member> members;  // 제네릭으로 타입 정보를 알 수 있음

//    @OneToMany(targetEntity = Member.class) // 제네릭 사용 안할 시
//    private List members;


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
