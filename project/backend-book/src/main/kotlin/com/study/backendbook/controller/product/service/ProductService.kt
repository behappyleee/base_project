package com.study.backendbook.controller.product.service

import com.study.backendbook.controller.product.dto.Product
import com.study.backendbook.controller.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService {

    fun createProduct(product: Product) {
        ProductRepository.saveProduct(product = product)
    }
}
