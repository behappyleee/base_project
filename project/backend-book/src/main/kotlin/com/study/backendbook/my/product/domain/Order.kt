package com.study.backendbook.my.product.domain

import com.study.backendbook.my.product.type.OrderState
import java.math.BigDecimal

data class Order(
    var id: Long,
    val products: List<Product>,
    val totalPrice: BigDecimal,
    val state: OrderState,
) {
    fun calculateTotalPrice(products: List<Product>): BigDecimal = products.sumOf { product -> BigDecimal.valueOf(product.price.toLong()) }
}
