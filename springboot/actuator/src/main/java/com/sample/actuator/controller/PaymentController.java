package com.sample.actuator.controller;

import com.sample.actuator.enums.PaymentStatus;
import com.sample.actuator.model.PaymentRequest;
import com.sample.actuator.model.PaymentResponse;
import com.sample.actuator.services.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final OrderService orderService;

    private final MeterRegistry registry;

    @PostMapping("/{orderId}/payment")
    public PaymentResponse processPayments(@PathVariable String orderId, @RequestBody PaymentRequest request) {
        System.out.println("Processing Payment For Order : " + orderId);

        PaymentResponse response = new PaymentResponse();
        response.setPaymentTransactionId(UUID.randomUUID().toString());
        response.setPaymentStatus(PaymentStatus.SUCCESS);

        return response;
    }

}
