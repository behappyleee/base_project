package com.study.backendbook.controller.product.controller

import com.study.backendbook.controller.product.domain.Product
import com.study.backendbook.controller.product.service.ProductService
import com.study.backendbook.controller.product.controller.dto.ProductDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
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

    @GetMapping("/products/{id}")
    fun findById(
        @PathVariable(name = "id") id: Long,
    ) = service.findById(id = id)

    // TODO - URL Path 명 적절하게 수정하기 !
    @GetMapping("/products:name")
    fun findByName(
        @RequestParam(name = "name", required = false) name: String
    ): List<ProductDto> =
        service.findByContainsName(name = name)
            .map { product ->
                ProductDto.toProductDto(product = product)
            }

    @PutMapping("/products/{id}")
    fun updateProduct(
        @RequestParam(name = "id", required = true) id: Long,
        @RequestBody productDto: ProductDto,
    ): ProductDto =
        ProductDto.toProductDto(
            product = service.updateProduct(
                product = Product.toProduct(
                    productDto = productDto.copy(
                        id = id,
                    )
                )
            )
        )
}
