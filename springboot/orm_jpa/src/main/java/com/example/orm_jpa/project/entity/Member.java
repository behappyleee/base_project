package com.example.orm_jpa.project.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//  Table 어노테이션이 없으면 클래스명과 같은 테이블명을 매핑
public class Member {

    // 식별자는 ID 와 GeneratedValue 를 통하여 데이터 베이스에서 자동 생성이 됨
    // GeneratedValue 의 기본 생성 잔략은 AUTO 이므로 선택한 데이터베이스 방언에 따라 Identity, Sequence, Table 중 하나가 선택이 됨
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipcode;

    // JPA 위 방법이 아닌
    // 연관 관계로 매핑 (OneToMany 관계에서 mappedBy 를 사용하여 연관 관계 주인을 설정)
    @OneToMany(mappedBy = "member")
    private List <Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
