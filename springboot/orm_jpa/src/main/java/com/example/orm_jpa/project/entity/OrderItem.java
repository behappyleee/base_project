package com.example.orm_jpa.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    // ITEM_ID 외래키 값
//    @Column(name = "ITEM_ID")
//    private Long itemId;

    // JPA 이용하여 연관 관계 설정
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    // ORDER_ID 외래키 값
//    @Column(name = "ORDER_ID")
//    private Long orderId;

    // JPA 이용하여 연관 관계 설정
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice; // 주문 가격

    private int count;      // 주문 수량

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(Long itemId) {
//        this.itemId = itemId;
//    }
//
//    public Long getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Long orderId) {
//        this.orderId = orderId;
//    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
