package com.study.backendbook.controller.product.controller.dto

import com.study.backendbook.controller.product.domain.Product
import jakarta.validation.constraints.Size
import java.util.Vector

// 실무에서는 DTO 가 자주 변경 되기에 표현 계층에서 사용 되는 데이터 클래스와 서비스에서 사용되는 데이터 클래스를 분리 시키는게 낫다
// DTO 는 표현 계층 부터 어플리케이션 계층 까지 역할을 하고 그 안쪽까지는 전달이 되지는 않는다.
data class ProductDto(
    var id: Long,
    val name: String,
    val price: Number,
    val amount: Number,
) {
    companion object {
        fun toProductDto(product: Product): ProductDto {
            return ProductDto(
                id = product.id,
                name = product.name,
                price = product.price,
                amount = product.amount,
            )
        }
    }
}
