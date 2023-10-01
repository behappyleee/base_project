package com.example.orm_jpa.project.entity;

import com.example.orm_jpa.project.entity.common.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity { // 매핑 정보인 BaseEntity 를 상속 (날짜 데이터 엔티티) 상속시 DDL 생성 시 에도 자동 추가 됨

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

//    @Column(name = "MEMBER_ID")
//    private Long memberId;

    // JPA 위 방법이 아닌
    // 연관 관계로 매핑
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @OneToOne          // 주문과 배송은 1:1 관계 (OneToOne)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;  // 배송 정보

    @Temporal(TemporalType.TIMESTAMP)   // 날짜 형식 타입
    private Date orderDate;     // 주문 날짜

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태

    // 연관 관계 메서드
    public void setMember(Member member) {
        // 기존 관계 제거
        if(this.member != null) {
            member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

}
