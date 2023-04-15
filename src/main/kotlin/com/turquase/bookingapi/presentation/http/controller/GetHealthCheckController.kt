package com.turquase.bookingapi.presentation.http.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
final class GetHealthCheckController {

    @GetMapping(
        value = ["healthcheck"],
        produces = ["application/json"]
    )
    @Operation(
        summary = "Health check",
        description = "Retrive the health status of booking api"
    )
    operator fun invoke(): String {
        return "{\n\t\"booking-api\": \"is_alive\"\n}"
    }
}
