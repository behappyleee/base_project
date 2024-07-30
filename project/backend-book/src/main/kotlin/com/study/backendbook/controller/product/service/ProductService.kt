package com.study.backendbook.controller.product.service

import com.study.backendbook.controller.product.repository.ProductRepository
import com.study.backendbook.controller.product.domain.Product
import org.springframework.stereotype.Service

@Service
class ProductService {

    // 어플리케이션 계층 Service
    fun createProduct(product: Product): Product = ProductRepository.saveProduct(product = product)

    fun getProducts() = ProductRepository.findAll()

    fun findById(id: Long) = ProductRepository.findById(id = id)

    fun findByContainsName(name: String): List<Product> = ProductRepository.findByContainsName(name = name)

    fun updateProduct(product: Product): Product = ProductRepository.updateProduct(product = product)
}
