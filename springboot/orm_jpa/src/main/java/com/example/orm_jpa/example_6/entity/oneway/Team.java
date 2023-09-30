package com.example.orm_jpa.example_6.entity.oneway;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class Team {
    
    // Team 엔티티에는 Member 를 참조할 수 있는 필드가 없으므로 단방향 관계
    
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;


}
