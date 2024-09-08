package com.study.backendbook.my.product.service

import com.study.backendbook.my.product.domain.Order
import com.study.backendbook.my.product.domain.Product
import com.study.backendbook.my.product.repository.DatabaseProductRepository
import com.study.backendbook.my.product.repository.ListOrderRepository
import com.study.backendbook.my.product.repository.ListProductRepository
import com.study.backendbook.my.product.service.dto.OrderProduct
import com.study.backendbook.my.product.service.dto.OrderProductRequest
import com.study.backendbook.my.product.service.dto.OrderProductResponse
import com.study.backendbook.my.product.type.OrderState
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class OrderService(
    private val databaseProductRepository: DatabaseProductRepository,
    private val listProductRepository: ListProductRepository,
    private val listOrderRepository: ListOrderRepository,
) {
    fun createOrders(orderProductRequests: List<OrderProductRequest>): OrderProductResponse {
        // 재고가 있는 지 재고가 존재하는 상황이면 주문을 생성
        val orderProducts = makeOrderedProducts(
            orders = orderProductRequests,
        )

        // 재고가 존재하면 재고에서 차감
        decreaseProductStockAmount(orderedProducts = orderProducts)

        val orders =
            orderProducts.map { orderProduct ->
                Order(
                    id = orderProduct.id,
                    products = orderProducts.map {
                        Product(
                            id = it.id,
                            name = it.name,
                            price = it.price,
                            amount = it.amount
                        )
                    },
                    totalPrice = orderProducts.sumOf { BigDecimal.valueOf(it.price.toLong()) },
                    state = OrderState.CREATED,
                )
            }

        orders.forEach { order ->
            listOrderRepository.addOrder(order = order)
        }

        // 생성 된 주문 을 ResponseDto 로 반환
        return OrderProductResponse(
            id = 1L,
            orderedProducts = orderProducts.map {
                OrderProduct(
                    id = it.id,
                    name = it.name,
                    price = BigDecimal.valueOf(it.price.toLong()),
                    amount = it.amount.toInt(),
                )
            },
            totalPrice = orderProducts.sumOf { orderProduct -> BigDecimal.valueOf(orderProduct.price.toLong()) },
            state = OrderState.CREATED,
        )
    }

    private fun makeOrderedProducts(
        orders: List<OrderProductRequest>,
    ): List<Product> {
        return orders.map { order ->
            val product = listProductRepository.findById(id = order.id)
            product.checkEnoughAmountOrThrow(orderAmount = order.amount)

            Product(
                id = product.id,
                name = product.name,
                price = product.price,
                amount = product.amount,
            )
        }
    }

    private fun decreaseProductStockAmount(orderedProducts: List<Product>) {
        orderedProducts.forEach { orderedProduct ->
            val decreaseProduct =
                orderedProduct.decreaseProductAmountByOrderedProducs(orderedAmount = orderedProduct.amount)

            listProductRepository.update(product = decreaseProduct)
        }
    }
}
