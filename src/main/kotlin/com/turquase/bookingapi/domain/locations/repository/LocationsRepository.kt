package com.turquase.bookingapi.domain.locations.repository

import com.turquase.bookingapi.domain.locations.entity.LocationEntity

interface LocationsRepository {
    fun save(location: LocationEntity)
    fun persistAll(users: Iterable<LocationEntity>)
    fun findOneById(id: Long): LocationEntity?
}
