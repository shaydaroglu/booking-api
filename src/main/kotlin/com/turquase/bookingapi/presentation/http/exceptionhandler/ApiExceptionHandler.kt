package com.turquase.bookingapi.presentation.http.exceptionhandler

import com.turquase.bookingapi.config.toSnakeCase
import com.turquase.bookingapi.presentation.http.response.ApiError
import com.turquase.bookingapi.presentation.http.response.ApiErrorResponse
import com.turquase.bookingapi.presentation.http.response.toResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.webjars.NotFoundException
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(InternalError::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleInternalServerError(exception: InternalError, request: WebRequest): ResponseEntity<ErrorDetails> {
        logger.error(exception.message, exception)
        return ResponseEntity(
            ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, exception.message),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(exception: NotFoundException, request: WebRequest): ResponseEntity<ErrorDetails> {
        return ResponseEntity(
            ErrorDetails(HttpStatus.NOT_FOUND, exception.message),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleConstraintViolation(exception: ConstraintViolationException): ResponseEntity<ApiErrorResponse> {
        val errors = mutableListOf<ApiError>()

        exception.constraintViolations.forEach {
            errors.add(
                ApiError(
                    it.message,
                    HttpStatus.BAD_REQUEST.name.lowercase(),
                    it.propertyPath.toString().toSnakeCase()
                )
            )
        }

        return ApiErrorResponse(HttpStatus.BAD_REQUEST, errors.toList()).toResponseEntity()
    }
}
