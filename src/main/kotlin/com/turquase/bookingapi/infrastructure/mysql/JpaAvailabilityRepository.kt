package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.availability.entity.AvailabilityEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaAvailabilityRepository : JpaRepository<AvailabilityEntity, Long>
