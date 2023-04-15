package com.turquase.bookingapi.application.bus

import com.cloudogu.cb.Command
import com.cloudogu.cb.CommandBus
import org.springframework.context.annotation.Primary
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@Primary
class ValidatorCommandBus(
    private val validator: Validator,
    private val handler: CommandBus
) : CommandBus {
    override fun <R : Any, C : Command<R>> execute(command: C): R? {
        val violations = this.validator.validate(command)

        if (violations.isEmpty()) {
            return this.handler.execute(command)
        }

        throw ConstraintViolationException(violations)
    }
}
