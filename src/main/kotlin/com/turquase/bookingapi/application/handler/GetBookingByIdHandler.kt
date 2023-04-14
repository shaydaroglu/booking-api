package com.turquase.bookingapi.application.handler

import com.cloudogu.cb.CommandHandler
import com.turquase.bookingapi.domain.booking.entity.BookingEntity
import com.turquase.bookingapi.domain.booking.exception.BookingNotFoundException
import com.turquase.bookingapi.domain.booking.query.GetBookingById
import com.turquase.bookingapi.domain.booking.repository.BookingRepository
import org.springframework.stereotype.Component

@Component
class GetBookingByIdHandler(
    private val repository: BookingRepository
) : CommandHandler<BookingEntity, GetBookingById> {
    override fun handle(query: GetBookingById): BookingEntity {
        val bookingId = query.getId()

        return repository.findOneById(bookingId)
            ?: throw BookingNotFoundException(
                String.format("Booking for ID: $bookingId was not found.")
            )
    }
}
