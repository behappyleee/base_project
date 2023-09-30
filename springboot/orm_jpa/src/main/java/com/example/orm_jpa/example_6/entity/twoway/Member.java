package com.example.orm_jpa.example_6.entity.twoway;

import jakarta.persistence.*;

@Entity
public class Member {

    // 일대다와 다대일 연관 관계는 항상 다(N) 쪽에 외래 키가 존재, 다쪽에 Member 테이블이 외래키를 가지고 있음
    // JPA 는 외래 키를 관리할 때 연관 관계의 주인만 사용, 주인이 아닌 Team.members 는 조회를 위한 JPQL 이나 객체 그래프를 탐색 시 사용

    // !!! 중요한 점 !!!!
    // 양방향 연관 관게는 항상 서로 참조가 가능하여야 함 !!!

    // Team 과 Member 모두 서로 참조 할 수 있는 필드 값이 존재 하므로 Team 과 Member 는 양방향 관계
    // 양방향은 항상 외래키가 있는 곳이 주인임

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    // ManyToOne 쪽이 항상 연관 관계에서 주인 이므로 ManyToOne 어노테이션에서는 mappedBy 속성이 없음
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    public void setTeam(Team team) {
        this.team = team;
        // 무한 루프에 빠지지 않도록 설정
        if(!team.getMembers().contains(this)) {
            team.getMembers().add(this);
        }
    }


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

}
