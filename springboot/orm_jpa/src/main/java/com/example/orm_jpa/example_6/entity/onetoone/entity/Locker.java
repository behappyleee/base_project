package com.example.orm_jpa.example_6.entity.onetoone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LOCKER")
public class Locker {

    // Member 와 양방향 관계 이므로 주인을 정해주어야 함
    // Member 테이블이 외래 키를 가지고 있으므로 Member 엔티티에 있는 Member.locker 가 연관 관계의 주인임.
    // 따라서 반대 매핑인 사물함의 Locker.Member 는 mappedBy 를 선언하여 연관 관계의 주인이 아니라고 설정

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

}
