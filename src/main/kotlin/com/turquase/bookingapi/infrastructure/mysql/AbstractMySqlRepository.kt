package com.turquase.bookingapi.infrastructure.mysql

import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityManager

abstract class AbstractMySqlRepository {
    protected lateinit var manager: EntityManager

    @Autowired
    fun withManager(manager: EntityManager) {
        this.manager = manager
    }
}
