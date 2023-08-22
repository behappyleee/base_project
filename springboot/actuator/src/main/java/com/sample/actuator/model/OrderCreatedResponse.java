package com.sample.actuator.model;

import lombok.Data;

@Data
public class OrderCreatedResponse {

    String customerId;
    String orderId;

}
