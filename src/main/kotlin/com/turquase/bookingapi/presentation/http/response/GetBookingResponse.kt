package com.turquase.bookingapi.presentation.http.response

import com.fasterxml.jackson.annotation.JsonIgnore
import com.turquase.bookingapi.domain.booking.entity.BookingEntity
import io.swagger.v3.oas.annotations.media.Schema
import java.time.format.DateTimeFormatter

@SuppressWarnings("unused")
data class GetBookingResponse(@JsonIgnore private val booking: BookingEntity) {
    @Schema(description = "Id of the booking", example = "123")
    val id = booking.id

    @Schema(name = "user_id", description = "Booking user id", example = "123")
    val userId = booking.user?.id

    @Schema(name = "name_under", description = "Person name booking belongs to", example = "Sercan")
    val name = booking.user?.firstName

    @Schema(name = "start_time", description = "Booking start time", format = "date", example = "2023-14-04")
    val startTime = booking.startTime?.format(DateTimeFormatter.ISO_DATE_TIME)

    @Schema(name = "end_time", description = "Booking end time", format = "date", example = "2023-14-04")
    val endTime = booking.endTime?.format(DateTimeFormatter.ISO_DATE_TIME)

    @Schema(description = "Booked location")
    val location = GetLocationResponse(booking.location!!)

    @Schema(description = "Booked service")
    val service = GetServiceResponse(booking.service!!)

    @Schema(description = "Booking status", example = "active")
    val status = booking.status
}
