package com.study.backendbook.controller.product.repository

import com.study.backendbook.controller.product.domain.Product
import java.util.concurrent.atomic.AtomicLong

// Repository DB 연결이 아닌 임시로 object 에 List 를 선언하여 사용
object ProductRepository {

    // 인프라 스트럭처 레이어 Infrastructure Layer
    // Kotlin 에 mutableList 는 ThreadSafe 하지 않음 !
    private val products = mutableListOf<Product>()

    private val sequence = AtomicLong(1)

    fun saveProduct(product: Product): Product {
        val saveProduct =
            product.copy(
                id = sequence.getAndAdd(1L)
            )

        products.add(saveProduct)
        return saveProduct
    }

    fun findAll(): List<Product> = products

    fun findById(id: Long) = products.first { product -> product.id == id }
}


