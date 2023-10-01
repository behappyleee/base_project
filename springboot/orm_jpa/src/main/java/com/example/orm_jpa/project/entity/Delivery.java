package com.example.orm_jpa.project.entity;

import com.example.orm_jpa.project.enums.DeliveryStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    // Order 와 Delivery 는 1:1 관계임 그 반대도 일대일 관계임, 여기서는 Order 가 매핑 된 Orders 를 주 테이블로 보고 주 테이블에 외래키를 두었으므로
    // 외래 키가 있는 Order.delivery 가 연관 관계의 주인이 됨
    @OneToOne(mappedBy = "delivery")    // 양방향 매핑 이지만 연관관계의 주인이 아닐 시 에는 mappedBy 속성을 사용
    private Order order;

    private String city;

    private String street;

    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
