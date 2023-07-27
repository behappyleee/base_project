package com.sample.data.rest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    
    // 단방향은 한 쪽의 엔티티가 상대 엔티티를 참조하고 있는 상태
    // 그렇기에 Member 엔티티에만 @ManyToOne 어노테이션이 존재
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    // JoinColumn 어노테이션은 외래 키를 맵핑할 때 사용, name 속성에는 맵핑 할 외래 키 이름을 지정
    // Hibernate 가 테이블을 정의하는 SQL 문을 보면 Member 테이블에 외래키로 TEAM_ID 를 가짐
    // 만약 Team 에서도 Member 정보를 가져오고 싶으면 양방향 관계를 맺어야 함
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
