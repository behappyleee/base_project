package com.study.backendbook.controller.product.repository

import com.study.backendbook.controller.product.domain.Product

// Repository DB 연결이 아닌 임시로 object 에 List 를 선언하여 사용
object ProductRepository {

    // 인프라 스트럭처 레이어 Infrastructure Layer
    // Kotlin 에 mutableList 는 ThreadSafe 하지 않음 !
    private val products = mutableListOf<Product>()

    fun saveProduct(product: Product) {
        products.add(
            product.copy(
                id = (products.size + 1).toLong()
            )
        )
    }

    fun getProducts(): List<Product> {
        return products
    }
}