package com.turquase.bookingapi.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import liquibase.integration.spring.SpringLiquibase
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["com.turquase.bookingapi.infrastructure.mysql"],
    entityManagerFactoryRef = "primaryEntityManagerFactory",
    transactionManagerRef = "primaryTransactionManager"
)
class PrimaryDataSourceConfig {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    fun primaryDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.liquibase")
    fun liquibaseProperties(): LiquibaseProperties {
        return LiquibaseProperties()
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    fun hikariProperties(): HikariConfig {
        return HikariConfig()
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.jpa")
    fun jpaProperties(): JpaProperties {
        return JpaProperties()
    }

    @Primary
    @Bean(name = ["primaryDataSource"])
    fun primaryDataSource(primaryDataSourceProperties: DataSourceProperties, hikariConfig: HikariConfig): DataSource {
        return primaryDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build().apply {
            maximumPoolSize = hikariConfig.maximumPoolSize
        }
    }

    @Primary
    @Bean(name = ["primaryEntityManagerFactory"])
    fun primaryEntityManagerFactory(
        primaryEntityManagerFactoryBuilder: EntityManagerFactoryBuilder,
        primaryDataSource: DataSource,
        jpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        jpaProperties.properties["hibernate.dialect"] = "org.hibernate.dialect.MySQLInnoDBDialect"
        jpaProperties.properties["hibernate.hbm2ddl.auto"] = "none"
        jpaProperties.properties["hibernate.physical_naming_strategy"] =
            "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy"
        return primaryEntityManagerFactoryBuilder
            .dataSource(primaryDataSource)
            .packages("com.turquase.bookingapi.domain")
            .persistenceUnit("primaryDataSource")
            .properties(jpaProperties.properties)
            .build()
    }

    @Primary
    @Bean(name = ["primaryTransactionManager"])
    fun primaryTransactionManager(primaryEntityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(primaryEntityManagerFactory)
    }

    @Bean
    fun primaryLiquibase(primaryDataSource: DataSource, liquibaseProperties: LiquibaseProperties): SpringLiquibase {
        val liquibase = SpringLiquibase().apply {
            dataSource = primaryDataSource
            changeLog = liquibaseProperties.changeLog
            contexts = liquibaseProperties.contexts
            defaultSchema = liquibaseProperties.defaultSchema
            isDropFirst = liquibaseProperties.isDropFirst
            setShouldRun(liquibaseProperties.isEnabled)
            labelFilter = liquibaseProperties.labels
            setChangeLogParameters(liquibaseProperties.parameters)
            setRollbackFile(liquibaseProperties.rollbackFile)
        }

        return liquibase
    }
}
