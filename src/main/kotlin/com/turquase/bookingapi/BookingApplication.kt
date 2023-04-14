package com.turquase.bookingapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class BookingApplication

fun main(args: Array<String>) {
    runApplication<BookingApplication>(*args)
}
