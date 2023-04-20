package com.turquase.bookingapi.presentation.http.response

import com.fasterxml.jackson.annotation.JsonIgnore
import com.turquase.bookingapi.domain.locations.entity.LocationEntity

class GetLocationResponse(@JsonIgnore private val location: LocationEntity) {
    val id = location.id
    val name = location.name
    val address = location.address
    val city = location.city
    val state = location.state
    val country = location.country
    val latitude = location.latitude
    val longitude = location.longitude
}
