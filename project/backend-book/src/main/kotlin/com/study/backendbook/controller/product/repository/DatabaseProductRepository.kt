package com.study.backendbook.controller.product.repository

import com.study.backendbook.controller.product.domain.EntityNotFoundException
import com.study.backendbook.controller.product.domain.Product
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

// all-open 을 사용을 해 보는건 어떨까 !
@Repository
open class DatabaseProductRepository(
    private val jdbcTemplate: JdbcTemplate,
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate,
) {
    // TODO - JdbcTemplate 에 의존성이 주입 되지 않음 의존성 주입이 필요 !
    // 의존성이 주입이 되지 않아 Cannot invoke "org.springframework.jdbc.core.JdbcTemplate.update(String, Object[])" because "this.jdbcTemplate" is null
    // 해당 에러가 발생
    fun add(product: Product): Product {
        val keyHolder = GeneratedKeyHolder()

        val sqlParameters = BeanPropertySqlParameterSource(product)
        namedParameterJdbcTemplate.update(
            "INSERT INTO products (name, price, amount) VALUES (:name, :price, :amout)",
            sqlParameters,
            keyHolder,
        )

        val generatedId = keyHolder.key ?: throw RuntimeException("Key 값이 존재하지 않습니다 ... !!")

        product.id = generatedId.toLong()
        return product
    }

    fun findById(id: Long): Product {
        // MapParameterSource 는 BeanPropertySqlParameterSource 와 다르게 Product 같은 객체를 매핑해주는 것이 아닌 Key-Value 형태 매핑이 가능
        val namedParameter = MapSqlParameterSource("id", id)

        return namedParameterJdbcTemplate.queryForObject(
            "SELECT id, name, price, amount FROM products WHERE id=:id", namedParameter, BeanPropertyRowMapper(Product::class.java),
        ) ?: throw EntityNotFoundException("조회 하신 $id 의 상품을 찾을 수 없습니다.")
    }

    fun findAll(): List<Product> {
        return jdbcTemplate.query(
            "SELECT id, name, price, amount FROM products",
            BeanPropertyRowMapper(Product::class.java),
        )
    }

    fun findByName(name: String): List<Product> {
        val namedParameter = MapSqlParameterSource("name", "%$name%")
        return namedParameterJdbcTemplate.query(
            "SELECT id, name, price, amount WHERE name like :name",
            namedParameter,
            BeanPropertyRowMapper(Product::class.java),
        )
    }

    fun update(product: Product): Product {
        val namedParameters = BeanPropertySqlParameterSource(product)

        namedParameterJdbcTemplate.update(
            "UPDATE products SET name=:name, price=:price, amount=:amount WHERE id=:id",
            namedParameters,
        )

        // 그냥 기존 Request Product 를 Response 해주는 게 좋을까 .. ?!
        return product
    }

    fun delete(id: Long) {
        val namedParameter = MapSqlParameterSource("id", id)

        jdbcTemplate.update(
            "DELETE FROM products WHERE id=:id",
            namedParameter,
        )
    }
}
