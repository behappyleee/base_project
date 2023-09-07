package com.sample.data.jpa.rest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // 양 방향 관계 맺기 Team 기준으로 1 : N 관계임 Member 와
    // Team 은 Member 를 List 로 가짐
    // 만약 양 쪽 엔티티에 엔티티를 참조 할 수 있는 객체가 둘다 있으면 양방향이고 한쪽에만 있으면 단방향임
    // 연관 관계에 주인을 정하는 방법은 mappedBy 속성을 사용하지 않고 @JoinColumn 을 사용 주인이 아닌 엔티티 클래스는 mappedBy 속성을 사용해 주인을 지정
    // mappedBy 의 속성으로 Member 테이블의 Team 필드 이름을 명시, Team DB 에 Members FK 컬럼을 만들지 않기 위하여
    @OneToMany(mappedBy = "team")   // 연관 관계의 주인을 정하기 위하 mappedBy 속성을 추가 (연관 관계에 주인을 정하는 방법임)
    private List <Member> members = new ArrayList<>();
    

}
