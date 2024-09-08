package com.study.backendbook.my.product.domain

class ProductAmountNotEnoughException(private val errorMessage: String = "주문 하실려는 상품의 수량이 부족합니다.")
    : RuntimeException(errorMessage)
