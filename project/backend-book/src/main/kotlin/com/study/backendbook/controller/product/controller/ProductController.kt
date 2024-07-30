package com.study.backendbook.controller.product.controller

import com.study.backendbook.controller.product.domain.Product
import com.study.backendbook.controller.product.service.ProductService
import com.study.backendbook.controller.product.controller.dto.ProductDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val service: ProductService,
) {
    // 표현 계층 Controller
    // 표현 계층 에서는 DTO 를 사용 어플리케이션 내부에서는 domain 을 사용
    @PostMapping("/products")
    fun createProduct(
        @RequestBody productDto: ProductDto
    ): ProductDto =
        ProductDto.toProductDto(
            product = service.createProduct(
                product = Product.toProduct(productDto = productDto)
            )
        )

    @GetMapping("/products")
    fun getProducts() = service.getProducts()
}

