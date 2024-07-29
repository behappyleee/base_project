package com.study.backendbook.controller.product.repository

import com.study.backendbook.controller.product.domain.Product
import java.util.concurrent.atomic.AtomicLong

// Repository DB 연결이 아닌 임시로 object 에 List 를 선언하여 사용
object ProductRepository {

    // 인프라 스트럭처 레이어 Infrastructure Layer
    // Kotlin 에 mutableList 는 ThreadSafe 하지 않음 !
    private val products = mutableListOf<Product>()

    private val sequence = AtomicLong(1)

    fun saveProduct(product: Product) {
        products.add(
            product.copy(
                // TODO
                // data class 필드명 setter / getter 필드명 동일하게 사용이 안될까 ... ?! ----> 확인이 필요 !
                _id = sequence.getAndAdd(1L)
            )
        )
    }

    fun getProducts(): List<Product> {
        return products
    }
}