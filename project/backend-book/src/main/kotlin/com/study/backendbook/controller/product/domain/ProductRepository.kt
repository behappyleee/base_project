package com.study.backendbook.controller.product.domain

interface ProductRepository {

    // infrastructure 패키지가 더 적절해 보이지만 더 적절해 보이는 패키지는 사실 domain 패키지 이다.
    // Local 환경에서는 ListProductRepository
    // 서버 환경에서는 DatabaseRepository 를 실행해 달라는 요구 사항

    // 도메인 주도 설계에서 반드시 지켜져야 하는 의존성 방향 중 하나는 다른 모든 계층은 Infrastructure 계층에 의존하면 안됨

    open fun add(product: Product): Product

    open fun findById(id: Long): Product

    open fun findAll(): List<Product>

    open fun findByNameContaining(name: String): List<Product>

    open fun update(product: Product): Product

    open fun delete(id: Long)
}