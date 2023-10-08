package com.example.jpa_project.domain;

import jakarta.persistence.*;

/**
 * Created by holyeye on 2014. 3. 11..
 */

@Entity
public class Delivery {

    // 주문 시 하나의 배송 정보를 생성한다. 주문과 배송은 일대일 관계이다.

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //ENUM [READY(준비), COMP(배송)]

    public Delivery() {
    }

    public Delivery(Address address) {
        this.address = address;
        this.status = DeliveryStatus.READY;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address=" + address +
                ", status=" + status +
                '}';
    }
}
