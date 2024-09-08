package com.study.backendbook.my.product.controller

import com.study.backendbook.my.product.controller.dto.OrderProductRequestDto
import com.study.backendbook.my.product.controller.dto.OrderProductResponseDto
import com.study.backendbook.my.product.service.OrderService
import com.study.backendbook.my.product.service.dto.OrderProductRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderRestController(
    private val orderService: OrderService
) {
    // 상품 주문 API
    @PostMapping("/orders")
    fun createOrders(
        @RequestBody orderProductRequestDtos: List<OrderProductRequestDto>,
    ): ResponseEntity<OrderProductResponseDto> {
        return ResponseEntity.ok(
            OrderProductResponseDto.of(
                orderProductResponse = orderService.createOrders(
                    orderProductRequests =
                        orderProductRequestDtos.map { orderRequestDto ->
                            OrderProductRequestDto.toOrderProductRequestDto(
                                request = orderRequestDto,
                            )
                        }
                    )
            )
        )
    }
}
