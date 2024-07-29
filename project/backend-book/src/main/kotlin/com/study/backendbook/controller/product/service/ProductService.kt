package com.study.backendbook.controller.product.service

import com.study.backendbook.controller.product.domain.Product
import com.study.backendbook.controller.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService {

    // 어플리케이션 계층 Service

    fun createProduct(product: Product) {
        ProductRepository.saveProduct(product = product)
    }

    fun getProducts() = ProductRepository.getProducts()
}
