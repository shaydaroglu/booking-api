package com.turquase.bookingapi.domain.booking.query

import com.turquase.bookingapi.domain.booking.entity.BookingEntity
import com.turquase.bookingapi.domain.common.Query
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotEmpty

class GetBookingById(
    @field: NotEmpty(message = "booking ID must not be blank")
    @field: Parameter(
        `in` = ParameterIn.PATH,
        description = "Id of the booking",
        schema = Schema(type = "string")
    )
    private val id: String
) : Query<BookingEntity> {
    fun getId(): Long {
        return id.toLong()
    }
}
