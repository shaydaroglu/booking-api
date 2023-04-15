package com.turquase.bookingapi.infrastructure.mysql.bus

import com.cloudogu.cb.Command
import com.cloudogu.cb.CommandBus
import com.turquase.bookingapi.domain.common.DomainException
import org.springframework.transaction.support.TransactionTemplate

class TransactionalCommandBus(
    private val template: TransactionTemplate,
    private val handler: CommandBus
) : CommandBus {
    override fun <R : Any, C : Command<R>> execute(command: C): R? {
        val result = template.execute<R> {
            try {
                handler.execute(command)
            } catch (exception: Throwable) {
                it.setRollbackOnly()

                if (exception !is DomainException) {
                    throw InternalError(exception)
                }

                throw exception
            }
        }

        return result
    }
}
