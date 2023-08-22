package com.sample.actuator.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    String customerId;
    List<OrderLineItem> lineItems;

    public Order(String customerId, List<OrderLineItem> lineItems) {
        this.customerId = customerId;
        this.lineItems = lineItems;
    }

}
