package com.study.backendbook.controller.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Configuration
open class JdbcTemplateConfig {
    // Test 환경에서는 DataSource 가 존재하지 않으므로 Prod 환경에서만 Bean 을 생성시켜준다.
    @Bean
    @Profile(value = ["prod"])
    open fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @Profile(value = ["prod"])
    open fun namedParameterJdbcTemplate(dataSource: DataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }
}