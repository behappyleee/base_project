package com.study.backendbook.controller.product.domain

import com.study.backendbook.controller.product.controller.dto.ProductDto
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size

// 도메인 계층
// 도메인 객체는 어플리케이션에서 사용 되는 데이터와 그 데이터를 다루는 로직을 하나로 묶는 것
// 이때 단숞 데이터와 로직이 한 곳에 모이는 것 뿐만 아니라 애플리케이션의 핵심 지식이 포함 되어야 함

// 예를 들어 '상품은 재고 수량 이상으로 주문할 수 없다' 와 같은 개념이 비즈니스 로직이 될 수 있다. 최대한 이러한 로직이 모이도록 코드를 작성하면 도메인 코드가 된다.
// 반대로 도메인 객체에 비즈니스 로직이 모이지 않으면 비즈니스 로직이 서비스 코드애 구현이 되면 도메인 객체의 응집력이 낮아지고 서비스 코드와의 결합도가 증가하여 곳곳에 중복코드가 생김

// DTO Data Transfer Obejct - 데이터를 전송하는 역할을 가진 객체 클라이언트에게 노출되는 데이터 구조와 백엔드 애플리케이션 내부 데이터 구조를 분리하기 위하여 사용

// TODO - Study 필요 data class private 은 Response 시 왜 숨겨질까 .. ?!
data class Product(
    val id: Long,
    @Size(min = 1, max = 100)
    val name: String,

    // TODO - kotlin data class 에는 spring-boot-validtion 이 왜 안걸릴까 .. ?!
    @Max(1_000_000)
    @Min(0)
    val price: Number,

    val amount: Number,
) {
    // 인스턴스 생성 실패시 예외를 던짐
    init {
//        if (name.length > 100 || name.isEmpty()) {
//            throw RuntimeException("Domain 객체의 Name 길이가 적절하지 않습니다.")
//        }
    }
    companion object {
        fun toProduct(productDto: ProductDto): Product {
            return Product(
                id = productDto.id,
                name = productDto.name,
                price = productDto.price,
                amount = productDto.amount,
            )
        }
    }

    fun containName(name: String): Boolean = name.contains(name)
}
