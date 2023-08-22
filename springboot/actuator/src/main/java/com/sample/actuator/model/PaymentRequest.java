package com.sample.actuator.model;

import com.sample.actuator.enums.PaymentMode;
import lombok.Data;

@Data
public class PaymentRequest {

    String orderId;
    PaymentMode paymentMode;
    double amount;

}
