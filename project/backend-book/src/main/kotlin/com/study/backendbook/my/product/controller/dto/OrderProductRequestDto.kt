package com.study.backendbook.my.product.controller.dto

import com.study.backendbook.my.product.service.dto.OrderProductRequest

data class OrderProductRequestDto(
    val id: Long,
    val amount: Int,
) {
    companion object {
        fun toOrderProductRequestDto(request: OrderProductRequestDto) = OrderProductRequest(
            id = request.id,
            amount = request.amount,
        )
    }
}
