package com.study.backendbook.my.product.domain

interface OrderRepository {
    open fun addOrder(order: Order): Order
}