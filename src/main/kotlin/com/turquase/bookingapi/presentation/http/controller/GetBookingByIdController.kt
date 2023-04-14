package com.turquase.bookingapi.presentation.http.controller

import com.cloudogu.cb.CommandBus
import com.turquase.bookingapi.domain.booking.query.GetBookingById
import com.turquase.bookingapi.presentation.http.response.GetBookingResponse
import io.swagger.v3.oas.annotations.Operation
import org.springdoc.api.annotations.ParameterObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

class GetBookingByIdController(private val handler: CommandBus) {
    @GetMapping(
        value = ["/bookings/{id}"],
        produces = ["application/json"]
    )
    @Operation(
        summary = "Get booking by id",
        description = "Retrieve an Booking based on internal id",
        tags = ["bookings"]
    )
    operator fun invoke(
        @ParameterObject
        @PathVariable("id")
        query: GetBookingById
    ): GetBookingResponse {
        val booking = handler.execute(
            query
        )

        return GetBookingResponse(booking)
    }
}
