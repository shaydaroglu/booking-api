package com.turquase.bookingapi.domain.constraint

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@MustBeDocumented
@Constraint(validatedBy = [DateIfNotNullValidator::class])
@Retention(AnnotationRetention.RUNTIME)
annotation class DateIfNotNull(
    val message: String = "date is not valid",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class DateIfNotNullValidator : ConstraintValidator<DateIfNotNull, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        if (null == value) {
            return true
        }

        try {
            LocalDate.parse(
                value,
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
            )
        } catch (exception: Throwable) {
            return false
        }

        return true
    }
}
