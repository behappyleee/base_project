package com.study.backendbook.my.product.controller.dto

import com.study.backendbook.my.product.domain.Order
import com.study.backendbook.my.product.service.dto.OrderProductResponse
import com.study.backendbook.my.product.type.OrderState
import java.math.BigDecimal

data class OrderProductResponseDto(
    val id: Long,
    val orderedProducts: List<OrderProductDto>,
    val totalPrice: BigDecimal,
    val state: OrderState,
) {
    companion object {
        fun of(orderProductResponse: OrderProductResponse): OrderProductResponseDto {
            return OrderProductResponseDto(
                id = orderProductResponse.id,
                orderedProducts = orderProductResponse.orderedProducts.map { OrderProductDto.of(it) },
                totalPrice = orderProductResponse.totalPrice,
                state = orderProductResponse.state,
            )
        }
    }
}
