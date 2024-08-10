package com.study.backendbook.controller.product.repository

import com.study.backendbook.controller.product.domain.DatabaseConnectionFailException
import com.study.backendbook.controller.product.domain.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
open class DatabaseProductRepository(
    @Autowired
    private val jdbcTemplate: JdbcTemplate,
) {

    // TODO - JdbcTemplate 에 의존성이 주입 되지 않음 의존성 주입이 필요 !
    // 의존성이 주입이 되지 않아 Cannot invoke "org.springframework.jdbc.core.JdbcTemplate.update(String, Object[])" because "this.jdbcTemplate" is null
    // 해당 에러가 발생
    fun add(product: Product): Product {
         jdbcTemplate
            .update(
                "INSERT INTO products (name, price, amount) VALUES (?, ?, ?)",
                product.name, product.price, product.amount
            ) ?: throw DatabaseConnectionFailException(errorMessage = "Database 연결에 실패 하였습니다.")

        return product
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
