package com.turquase.bookingapi.presentation.http.exceptionhandler

import org.springframework.http.HttpStatus

data class ErrorDetails(val code: HttpStatus, val message: String?)
