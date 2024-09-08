package com.study.backendbook.my.product.service.dto

import java.math.BigDecimal

data class OrderProduct (
    val id: Long,
    val name: String,
    val price: BigDecimal,
    val amount: Int,
)
