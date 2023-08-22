package com.sample.actuator.model;

import lombok.Data;

@Data
public class OrderLineItem {

    String productId;
    Integer quantity;

}
