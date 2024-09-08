package com.study.backendbook.my.product.domain

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import org.hibernate.validator.constraints.Length

// 도메인 계층
// 도메인 객체는 어플리케이션에서 사용 되는 데이터와 그 데이터를 다루는 로직을 하나로 묶는 것
// 이때 단숞 데이터와 로직이 한 곳에 모이는 것 뿐만 아니라 애플리케이션의 핵심 지식이 포함 되어야 함

// 예를 들어 '상품은 재고 수량 이상으로 주문할 수 없다' 와 같은 개념이 비즈니스 로직이 될 수 있다. 최대한 이러한 로직이 모이도록 코드를 작성하면 도메인 코드가 된다.
// 반대로 도메인 객체에 비즈니스 로직이 모이지 않으면 비즈니스 로직이 서비스 코드애 구현이 되면 도메인 객체의 응집력이 낮아지고 서비스 코드와의 결합도가 증가하여 곳곳에 중복코드가 생김

// DTO Data Transfer Obejct - 데이터를 전송하는 역할을 가진 객체 클라이언트에게 노출되는 데이터 구조와 백엔드 애플리케이션 내부 데이터 구조를 분리하기 위하여 사용
// TODO - Study 필요 data class private 은 Response 시 왜 숨겨질까 .. ?!
data class Product(
    var id: Long,
    @field:Length(min = 1, max = 100, message = "Product Name 은 1 글자 이상 100 글자 이하만 가능 합니다.")
    val name: String,
    @field:Max(1_000_000, message = "Price 는 1,000,000 을 초과할 수 없습니다.")
    @field:Min(0, message = "Price 는 0원 이상 이여야 합니다.")
    val price: Number,
    var amount: Number,
) {
    // 인스턴스 생성 실패시 예외를 던짐, 위에 Validation 어노테이션으로 해당 로직을 대체
    init {
//        if (name.length > 100 || name.isEmpty()) {
//            throw RuntimeException("Domain 객체의 Name 길이가 적절하지 않습니다.")
//        }
    }

    companion object {
        // 도메인 주고 설계 법칙에 의하면 ProductDto 는 표현계층에 위치
        // Product 는 도메인 계층에 위치, Domain 계층에서는 어떠한 외부 계층에 의존을 하면 안된다.
        // Domain 계층은 다른 어떠한 계층을 의존하면 안되므로 표현 계층인 ProductDto 에서 변환 작업을 해주도록 한다.
//        fun toProduct(productDto: ProductDto): Product {
//            return Product(
//                // id = productDto.id,
//                id = 0, // TODO - id 는 어떻게하는게 좋을지 고민이 필요 ... !!
//                name = productDto.name,
//                price = productDto.price,
//                amount = productDto.amount,
//            )
//        }
    }

    fun containName(name: String): Boolean = name.contains(name)

    // 재고 수량이 충분 한지 확인하는 메서드랑 재고 수량을 감소 시키는 메서드를 따로 분리 시켜 놓은 이유는 상품 1에 대하여 재고를 확인 후 상품 1의 재고를 차감 후
    // 상품 3의 재고가 부족한 경우에는 어떻게 해야할까 ? 다시 상품 1을 롤백 시켜주어야 한다.
    // 실제로 애플리케이션을 개발할 때는 롤백이 필요한 상황이 아주 많다. 트랜잭셔널한 처리가 필요한 상황이다.
    fun checkEnoughAmountOrThrow(orderAmount: Int)  {
        if (this.amount.toInt() < orderAmount) {
            throw ProductAmountNotEnoughException(errorMessage = "주문 하실려는 상품의 수량이 부족 합니다. " +
                    "주문 하시려는 상품의 갯수 :$orderAmount , 남아있는 재고 수량 : ${this.amount}")
        }
    }

    fun decreaseProductAmountByOrderedProducs(orderedAmount: Number): Product {
        this.amount = this.amount.toInt() - orderedAmount.toInt()
        return this
    }
}
