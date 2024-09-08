package com.study.backendbook.my.product.controller.dto

import com.study.backendbook.my.product.service.dto.OrderProduct
import java.math.BigDecimal

data class OrderProductDto(
    val id: Long,
    val name: String,
    val price: BigDecimal,
    val amount: Int,
) {
    companion object {
        fun of(orderProduct: OrderProduct): OrderProductDto {
            return OrderProductDto(
                id = orderProduct.id,
                name = orderProduct.name,
                price = orderProduct.price,
                amount = orderProduct.amount,
            )
        }
    }
}
