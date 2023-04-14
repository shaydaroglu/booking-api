package com.turquase.bookingapi.presentation.http.response

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ApiErrorResponse(
    @JsonIgnore
    val status: HttpStatus,
    val errors: List<ApiError>
)

fun ApiErrorResponse.toResponseEntity(): ResponseEntity<ApiErrorResponse> {
    return ResponseEntity(this, status)
}

data class ApiError(
    val title: String?,
    val code: String?,
    val source: String? = null
)
