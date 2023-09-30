package com.example.orm_jpa.example_6.entity.manytomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MEMBER")
public class Member {

    // 정규화 된 테이블 2개로 다대다 표현이 불가능 하지만 객체에서는 다대다 표현이 가능하다.

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    // MEMBER_PRODUCT 는 MEMBER 테이블과 PRODUCT 테이블을 일대다 다대일 관계로 풀어내기 위한 그냥 연결 테이블임
    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT") // Join Table 연결 테이블을 지정, 
    private List <Product> product;


}
