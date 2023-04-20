package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.locations.entity.LocationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaLocationsRepository : JpaRepository<LocationEntity, Long>
