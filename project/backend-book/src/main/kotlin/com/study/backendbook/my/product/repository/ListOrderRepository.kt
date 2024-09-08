package com.study.backendbook.my.product.repository

import com.study.backendbook.my.product.domain.Order
import com.study.backendbook.my.product.domain.OrderRepository
import org.springframework.stereotype.Repository
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicLong

@Repository
class ListOrderRepository: OrderRepository {

    private val orders: MutableList<Order> = CopyOnWriteArrayList(listOf())

    private val sequence: AtomicLong = AtomicLong(1L)

    override fun addOrder(order: Order): Order {
        // Order Update 치는 위치가 여기가 맞을까 ... ?!
        order.id = sequence.getAndIncrement()

        orders.add(order)
        return order
    }
}
