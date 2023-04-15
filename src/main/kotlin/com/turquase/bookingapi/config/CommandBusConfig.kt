package com.turquase.bookingapi.config

import com.cloudogu.cb.CommandBus
import com.cloudogu.cb.spring.Registry
import com.cloudogu.cb.spring.SpringCommandBus
import com.turquase.bookingapi.application.bus.ValidatorCommandBus
import com.turquase.bookingapi.infrastructure.mysql.bus.TransactionalCommandBus
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionTemplate
import javax.validation.Validator

@Configuration
class CommandBusConfig {
    @Bean
    fun commandBus(
        manager: PlatformTransactionManager,
        context: ApplicationContext,
        validator: Validator
    ): CommandBus {
        return ValidatorCommandBus(
            validator,
            TransactionalCommandBus(
                TransactionTemplate(manager),
                SpringCommandBus(Registry(context))
            )
        )
    }
}
