package com.study.backendbook.my.product.repository

import com.study.backendbook.my.product.domain.EntityNotFoundException
import com.study.backendbook.my.product.domain.Product
import com.study.backendbook.my.product.domain.ProductRepository
import org.springframework.context.annotation.Profile
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

// all-open 을 사용을 해 보는건 어떨까 !
@Repository
@Profile(value = ["prod"])  // Profile 이 Prod 일 때만 해당 Bean 을 주입
open class DatabaseProductRepository(
    private val jdbcTemplate: JdbcTemplate,
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate,
): ProductRepository {
    override fun add(product: Product): Product {
        val keyHolder = GeneratedKeyHolder()

        val sqlParameters = BeanPropertySqlParameterSource(product)
        namedParameterJdbcTemplate.update(
            "INSERT INTO products (name, price, amount) VALUES (:name, :price, :amount)",
            sqlParameters,
            keyHolder,
        )

        val generatedId = keyHolder.key ?: throw RuntimeException("Key 값이 존재하지 않습니다 ... !!")

        product.id = generatedId.toLong()
        return product
    }

    override fun findById(id: Long): Product {
        // MapParameterSource 는 BeanPropertySqlParameterSource 와 다르게 Product 같은 객체를 매핑해주는 것이 아닌 Key-Value 형태 매핑이 가능
        val namedParameter = MapSqlParameterSource("id", id)

        // TODO - 에러를 제대로 잡지 못하는 것 같음 확인이 필요 ... !!!
        return try {
            namedParameterJdbcTemplate.queryForObject(
                "SELECT id, name, price, amount FROM products WHERE id=:id", namedParameter,
            ) { resultSet, _ ->
                Product(
                    id = resultSet.getLong("id"),
                    name = resultSet.getString("name"),
                    amount = resultSet.getInt("amount"),
                    price = resultSet.getInt("price"),
                )
            }
        } catch (e: EmptyResultDataAccessException) {
            throw EntityNotFoundException("조회 하신 $id 의 상품을 찾을 수 없습니다.")
        }
    }

    override fun findAll(): List<Product> {
        return jdbcTemplate.query(
            "SELECT id, name, price, amount FROM products",
        ) {
                resultSet, _ ->
            Product(
                id = resultSet.getLong("id"),
                name = resultSet.getString("name"),
                price = resultSet.getInt("price"),
                amount = resultSet.getInt("amount"),
            )
        }
    }

    override fun findByNameContaining(name: String): List<Product> {
        val namedParameter = MapSqlParameterSource("name", "%$name%")
        return namedParameterJdbcTemplate.query(
            "SELECT id, name, price, amount WHERE name like :name",
            namedParameter,
        ) {
                resultSet, _ ->
            Product(
                id = resultSet.getLong("id"),
                name = resultSet.getString("name"),
                price = resultSet.getInt("price"),
                amount = resultSet.getInt("amount"),
            )
        }
    }

    override fun update(product: Product): Product {
        val namedParameters = BeanPropertySqlParameterSource(product)

        namedParameterJdbcTemplate.update(
            "UPDATE products SET name=:name, price=:price, amount=:amount WHERE id=:id",
            namedParameters,
        )

        // 그냥 기존 Request Product 를 Response 해주는 게 좋을까 .. ?!
        return product
    }

    override fun delete(id: Long) {
        val namedParameter = MapSqlParameterSource("id", id)

        jdbcTemplate.update(
            "DELETE FROM products WHERE id=:id",
            namedParameter,
        )
    }
}
