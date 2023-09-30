package com.example.orm_jpa.example_6.entity.onetoone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {

    // 일대일 관계는 양쪽이 서로 하나의 관계만 가진다
    // 예를 들어 회원은 하나의 사물함만 사용하고 사물함도 하나의 외원에 의해서만 사용이 됨
    // 일대일 관계는 그 반대의 관계도 일대일 관계이다
    // 테이블 관계에서 일대다, 그 반대도 일대일 관계이다.
    // 다대일은 항상 다 (N) 쪽이 외래키를 가진다. 반면에 일대일 관계는 주 테이블이나 대상 테이블 둘 중 어느 곳이나 외래키를 가질 수 있다.

    // 전통적인 데이터 베이스 개발자들은 보통 대상 테이블에 외래 키를 두는 것을 선호한다. 이 방법의 장점은 테이블 관계를 일대일에서 일대다로 변경 시
    // 테이블 구조를 그대로 유지를 할 수 있다.

    // 일대일 관계를 구성 시 객체지향 개발자들은 주 테이블에 외래 키가 있는 것을 선호한다. JPA 도 주 테이블에 외래 키가 있으면 조금 더 편리하게 매핑이 가능

    // Member 가 주 테이블 이고
    // Locker 가 대상 테이블

    // 양방


    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    // 일대일 관계 이므로 객체 매핑 시 @OneToOne 어노테이션을 사용
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

}
