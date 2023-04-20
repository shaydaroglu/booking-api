package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.booking.entity.BookingEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaBookingsRepository : JpaRepository<BookingEntity, Long>
