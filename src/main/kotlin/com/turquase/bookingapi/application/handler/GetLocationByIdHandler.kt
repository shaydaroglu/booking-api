package com.turquase.bookingapi.application.handler

import com.cloudogu.cb.CommandHandler
import com.turquase.bookingapi.domain.locations.entity.LocationEntity
import com.turquase.bookingapi.domain.locations.exception.LocationNotFoundException
import com.turquase.bookingapi.domain.locations.query.GetLocationById
import com.turquase.bookingapi.domain.locations.repository.LocationsRepository
import org.springframework.stereotype.Component

@Component
class GetLocationByIdHandler(
    private val repository: LocationsRepository
) : CommandHandler<LocationEntity, GetLocationById> {
    override fun handle(query: GetLocationById): LocationEntity {
        val locationId = query.getId()

        return repository.findOneById(locationId)
            ?: throw LocationNotFoundException(
                String.format("Location for ID: $locationId was not found.")
            )
    }
}
