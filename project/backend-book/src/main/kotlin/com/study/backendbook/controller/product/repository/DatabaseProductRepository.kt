package com.study.backendbook.controller.product.repository

import com.study.backendbook.controller.product.domain.Product
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
open class DatabaseProductRepository(
    private val jdbcTemplate: JdbcTemplate,
) {

    fun add(product: Product): Product? {
        return null
    }

    fun findById(id: Long): Product? {
        return null
    }

    fun findAll(): List<Product>? {
        return null
    }

    fun findByName(name: String): List<Product>? {
        return null
    }

    fun update(product: Product): Product? {
        return null
    }

    fun delete(id: Long) {

    }
}
