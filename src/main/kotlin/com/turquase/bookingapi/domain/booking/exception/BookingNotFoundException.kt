package com.turquase.bookingapi.domain.booking.exception

import com.turquase.bookingapi.domain.common.DomainException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.webjars.NotFoundException

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class BookingNotFoundException(message: String?) : DomainException, NotFoundException(message)
