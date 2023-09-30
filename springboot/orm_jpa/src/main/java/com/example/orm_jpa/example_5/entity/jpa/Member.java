package com.example.orm_jpa.example_5.entity.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {
    // JPA 로 객체 연관 관계를 표현

    // 객체 연관 관계 : 회원 객체의 Member.team 필드를 사용
    // 테이블 연관 관계 : 회원 테이블의 Member.TEAM_ID 외래 키 컬럼을 사용

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    // Member.team 과 Member.TEAM_ID 를 매핑 하는 것이 연관 관계 매핑임
    // 연관 관계 매핑
    @ManyToOne   // ManyToOne : 이름 그대로 다대일 (N:1) 관계라는 매핑 정보, 회원 과 팀은 다대 일 관계, 연관 관계를 매핑 시 이렇게 다중성을 나타내는 어노테이션을 필수로 사용
    @JoinColumn(name = "TEAM_ID")   // JoinColumn 은 외래 키를 매핑 시 사용, name 속성에는 매핑 할 외래 키 이름을 지정
    private Team team;

    public void setTeam(Team team) {
        // 기존 Team 과 관계가 존재 시 Team 과의 관계를 제거
        if(this.team != null) {
            team.getMembers().remove(this);
        }
        this.team = team;
        // 이렇게 설정 시 해당 Member 클래스에만 Team 설정 시 양방향 연관 관계로 매핑이 됨
        team.getMembers().add(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

}
