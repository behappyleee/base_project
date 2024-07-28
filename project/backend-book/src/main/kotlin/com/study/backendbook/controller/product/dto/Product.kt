package com.study.backendbook.controller.product.dto

data class Product(
    val id: Long,
    val name: String,
    val price: Number,
    val amount: Number,
)