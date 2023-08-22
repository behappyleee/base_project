package com.sample.actuator.model;

import com.sample.actuator.enums.PaymentStatus;
import lombok.Data;

@Data
public class PaymentResponse {

    String paymentTransactionId;
    PaymentStatus paymentStatus;

}
