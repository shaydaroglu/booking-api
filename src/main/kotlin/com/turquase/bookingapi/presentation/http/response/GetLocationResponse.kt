package com.turquase.bookingapi.presentation.http.response

import com.fasterxml.jackson.annotation.JsonIgnore
import com.turquase.bookingapi.domain.locations.entity.LocationEntity

class GetLocationResponse(@JsonIgnore private val location: LocationEntity) {
    val name = location.name
    val address = location.address
    val city = location.city
    val country = location.country
    val latitude = location.latitude
    val longitude = location.longitude
}
