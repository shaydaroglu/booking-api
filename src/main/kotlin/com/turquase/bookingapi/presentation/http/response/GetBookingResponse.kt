package com.turquase.bookingapi.presentation.http.response

import com.fasterxml.jackson.annotation.JsonIgnore
import com.turquase.bookingapi.domain.booking.entity.BookingEntity
import io.swagger.v3.oas.annotations.media.Schema

data class GetBookingResponse(@JsonIgnore private val booking: BookingEntity) {
    @Schema(description = "Id of the booking", example = "123")
    val id = booking.id

    @Schema(name = "user_id", description = "Booking user id", example = "123")
    val userId = booking.user.id

    @Schema(name = "start_date", description = "Booking start time", format = "date", example = "2023-14-04")
    val startDate = booking.startTime.toString("yyyy-MM-dd")

    @Schema(name = "end_date", description = "Booking end time", format = "date", example = "2023-14-04")
    val endDate = booking.endTime.toString("yyyy-MM-dd")

    @Schema(description = "Booking location")
    val location = GetLocationResponse(booking.location)

    @Schema(description = "Booking service")
    val service = GetServiceResponse(booking.service)
}
