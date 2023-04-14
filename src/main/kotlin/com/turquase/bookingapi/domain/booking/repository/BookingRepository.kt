package com.turquase.bookingapi.domain.booking.repository

import com.turquase.bookingapi.domain.booking.entity.BookingEntity
import java.util.*

interface BookingRepository {
    fun save(booking: BookingEntity)
    fun persistAll(bookings: Iterable<BookingEntity>)
    fun findOneById(id: Long): BookingEntity?
}
