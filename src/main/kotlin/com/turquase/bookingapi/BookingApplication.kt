package com.turquase.bookingapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@OpenAPIDefinition(
    info = Info(
        title = "Booking service",
        version = "1.0"
    )
)
@EnableCaching
class BookingApplication

fun main(args: Array<String>) {
    runApplication<BookingApplication>(*args)
}
