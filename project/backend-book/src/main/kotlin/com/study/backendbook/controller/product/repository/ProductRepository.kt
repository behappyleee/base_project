package com.study.backendbook.controller.product.repository

import com.study.backendbook.controller.product.dto.Product

// Repository DB 연결이 아닌 임시로 object 에 List 를 선언하여 사용
object ProductRepository {

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