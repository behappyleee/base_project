package com.study.backendbook.my.product.service.dto

import com.study.backendbook.my.product.type.OrderState
import java.math.BigDecimal

data class OrderProductResponse(
    val id: Long,
    val orderedProducts: List<OrderProduct>,
    val totalPrice: BigDecimal,
    val state: OrderState,
)
