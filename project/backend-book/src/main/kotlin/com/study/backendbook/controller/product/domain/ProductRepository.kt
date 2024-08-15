package com.study.backendbook.controller.product.domain

interface ProductRepository {

    // infrastructure 패키지가 더 적절해 보이지만 더 적절해 보이는 패키지는 사실 domain 패키지 이다.
    // Local 환경에서는 ListProductRepository
    // 서버 환경에서는 DatabaseRepository 를 실행해 달라는 요구 사항

    // 도메인 주도 설계에서 반드시 지켜져야 하는 의존성 방향 중 하나는 다른 모든 계층은 Infrastructure 계층에 의존하면 안됨

    // ProductRepository 인터페이스를 만들면서 의존성의 방향이 바뀌었다. ProductService 는 ProductRepository 를 사용하므로 의존적이고
    // ListProductRepository 와 DatabaseRepository 는 ProductRepository 인터페이스를 구현하고 있으므로 의존적인 것이다.
    // 구체적인 클래스를 사용하던 코드를 추강화 하는 과정을 거치면서 추상적인 존재인 인터페이스 방향으로 의존성의 방향이 모이게 된다.
    // 이렇게 인터페이스에 의존하는 코드를 추상화에 의존하는 코드라고 표현한다.

    open fun add(product: Product): Product

    open fun findById(id: Long): Product

    open fun findAll(): List<Product>

    open fun findByNameContaining(name: String): List<Product>

    open fun update(product: Product): Product

    open fun delete(id: Long)
}