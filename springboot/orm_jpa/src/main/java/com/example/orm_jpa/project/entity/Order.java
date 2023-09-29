package com.example.orm_jpa.project.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Temporal(TemporalType.TIMESTAMP)   // 날짜 형식 타입
    private Date orderDate;     // 주문 날짜

    @Enumerated(EnumType.STRING)
    private OrderStatus status;





}
