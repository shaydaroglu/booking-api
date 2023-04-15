package com.turquase.bookingapi.domain.booking.command

import com.cloudogu.cb.Command
import com.turquase.bookingapi.domain.booking.entity.BookingEntity
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.NotEmpty

data class CreateBooking(
    @field: NotEmpty(message = "user_id can't be empty")
    @Schema(description = "User Id")
    val userId: Long? = null,

    @field: NotEmpty(message = "user_id can't be empty")
    @Schema(description = "User Id")
    val serviceId: Long? = null,

    @field: NotEmpty(message = "user_id can't be empty")
    @Schema(description = "User Id")
    val locationId: Long? = null,

    @field: NotEmpty(message = "user_id can't be empty")
    @Schema(description = "User Id")
    val date: String? = null,

    @field: NotEmpty(message = "user_id can't be empty")
    @Schema(description = "User Id")
    val startTime: String? = null,

    @field: NotEmpty(message = "user_id can't be empty")
    @Schema(description = "User Id")
    val endTime: String? = null,
) : Command<BookingEntity> {
    fun getBookingDate(): LocalDateTime? {
        return if (null == date) {
            return null
        } else {
            LocalDate.parse(
                date,
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
            ).atStartOfDay()
        }
    }
}
