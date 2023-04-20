package com.turquase.bookingapi.application.handler


import com.cloudogu.cb.CommandHandler
import com.turquase.bookingapi.domain.locations.command.CreateLocation
import com.turquase.bookingapi.domain.locations.entity.LocationEntity
import com.turquase.bookingapi.domain.locations.factory.LocationFactory
import com.turquase.bookingapi.domain.locations.repository.LocationsRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class CreateLocationHandler(
    private val locationsRepository: LocationsRepository,
    @Qualifier("create_location_factory")
    private val locationFactory: LocationFactory
) : CommandHandler<LocationEntity, CreateLocation> {
    override fun handle(command: CreateLocation): LocationEntity {
        val location: LocationEntity = locationFactory.createUsing(
            command
        )

        locationsRepository.save(location)

        return location
    }
}