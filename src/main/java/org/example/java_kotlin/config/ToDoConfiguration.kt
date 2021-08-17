package org.example.java_kotlin.config

import org.springframework.boot.context.properties.ConfigurationProperties
import com.zaxxer.hikari.HikariConfig
import org.flywaydb.core.Flyway
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@ConfigurationProperties("spring.flyway")
class ToDoConfiguration {

    @Bean
    fun datasource(
        @Value("\${spring.datasource.url}") url: String?,
        @Value("\${spring.datasource.username}") username: String?,
        @Value("\${spring.datasource.password}") password: String?,
        @Value("\${spring.datasource.driverClassName}") driver: String?
    ): DataSource {
        val config = HikariConfig()
        val flyway = Flyway.configure().dataSource(url, username, password).load()
        flyway.migrate()
        config.jdbcUrl = url
        config.username = username
        config.password = password
        config.driverClassName = driver
        return HikariDataSource(config)
    }

    @Bean
    fun database(dataSource: HikariDataSource): Database = Database.connect(dataSource)
}