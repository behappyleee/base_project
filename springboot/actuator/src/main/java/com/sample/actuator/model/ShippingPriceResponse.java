package com.sample.actuator.model;

import lombok.Data;

@Data
public class ShippingPriceResponse {

    String statusCode;
    Double amount;

}
