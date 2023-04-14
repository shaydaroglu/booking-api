package com.turquase.bookingapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.BodyFilter
import org.zalando.logbook.BodyFilters
import org.zalando.logbook.json.JsonBodyFilters

@Configuration
class LoggerConfig {
    @Bean
    fun bodyFilter(): BodyFilter {
        return BodyFilter.merge(
            BodyFilters.defaultValue(),
            JsonBodyFilters.replaceJsonStringProperty(
                setOf(
                    "email",
                ),
                "*filtered*"
            )
        )
    }
}
