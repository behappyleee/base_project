package com.study.backendbook.controller.product.controller

import com.study.backendbook.controller.product.dto.Product
import com.study.backendbook.controller.product.service.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val service: ProductService,
) {
    @PostMapping("/products")
    fun createProduct(
        @RequestBody product: Product
    ): Product {
        // TODO - Product 를 생성하고 리스트에 넣는 작업이 필요함 !
        service.createProduct(product = product)
        return product
    }
}
