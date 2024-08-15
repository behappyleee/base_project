package com.study.backendbook.controller.product.controller.dto

import com.study.backendbook.controller.product.domain.Product
import jakarta.validation.constraints.NotBlank

// 실무에서는 DTO 가 자주 변경 되기에 표현 계층에서 사용 되는 데이터 클래스와 서비스에서 사용되는 데이터 클래스를 분리 시키는게 낫다
// DTO 는 표현 계층 부터 어플리케이션 계층 까지 역할을 하고 그 안쪽까지는 전달이 되지는 않는다.
data class ProductDto(
    var id: Long = 0,
    // NotEmpty 검사 조건 - null or "" 경우를 검사
    // @field:NotEmpty(message = "ProductDto 의 Name 데이터는 값이 존재하여야 합니다. (null or empty string 생성 불가)")
    // NotBlank 검사 조건 - null or "" or " "  null, 빈 문자열, 공백만으로 이루어진 경우를 검사 경우를 검사
    @field:NotBlank(message = "ProductDto 의 Name 데이터는 값이 존재하여야 합니다. (null or empty string 생성 불가)")
    val name: String,
    val price: Number,
    val amount: Number,
) {
    companion object {
        // 도메인 주고 설계 법칙에 의하면 ProductDto 는 표현계층에 위치
        // Product 는 도메인 계층에 위치, Domain 계층에서는 어떠한 외부 계층에 의존을 하면 안된다.
        // 하여 표현계층에서 도메인 계층에 의존 할 수 있도록 해당 ProductDto 에서 ProductDto -> Product, Product -> ProductDto 로 변환하는 코드를 여기서 만든다.

        fun toProductDto(product: Product): ProductDto {
            return ProductDto(
                id = product.id,
                name = product.name,
                price = product.price,
                amount = product.amount,
            )
        }

        fun toProductEntity(productDto: ProductDto): Product {
            return Product(
                id = productDto.id,
                name = productDto.name,
                price = productDto.price,
                amount = productDto.amount,
            )
        }
    }
}
