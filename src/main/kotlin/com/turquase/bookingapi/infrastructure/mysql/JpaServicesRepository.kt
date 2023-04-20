package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.services.entity.ServiceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaServicesRepository : JpaRepository<ServiceEntity, Long>
