package com.turquase.bookingapi.domain.locations.factory

import com.turquase.bookingapi.domain.locations.command.CreateLocation
import com.turquase.bookingapi.domain.locations.entity.LocationEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component("create_location_factory")
class LocationFactory {
    val logger: Logger = LoggerFactory.getLogger(LocationFactory::class.java)

    fun createUsing(initializer: CreateLocation): LocationEntity {
        return try {
            createLocation(initializer)
        } catch (exception: Throwable) {
            logger.error("Error while creating location from factory due to ${exception.stackTraceToString()}")

            throw exception
        }
    }

    private fun createLocation(initializer: CreateLocation): LocationEntity {
        return LocationEntity(
            name = initializer.name!!,
            address = initializer.address!!,
            city = initializer.city!!,
            state = initializer.state!!,
            country = initializer.country!!,
            latitude = initializer.latitude!!,
            longitude = initializer.longitude!!
        )
    }

}