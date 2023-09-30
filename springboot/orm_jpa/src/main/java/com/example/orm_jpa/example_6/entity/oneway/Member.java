package com.example.orm_jpa.example_6.entity.oneway;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {

    // Member 엔티티에는 Team 을 참조 할 수 있는 필드가 있지만 Team 엔티티에는 Member 를 참조할 수 있는 필드가 없으므로 단방향 관계
    
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
