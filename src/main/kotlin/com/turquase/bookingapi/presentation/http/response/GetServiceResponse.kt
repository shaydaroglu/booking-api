package com.turquase.bookingapi.presentation.http.response

import com.fasterxml.jackson.annotation.JsonIgnore
import com.turquase.bookingapi.domain.services.entity.ServiceEntity

class GetServiceResponse(@JsonIgnore private val service: ServiceEntity) {
    val name = service.name
    val description = service.description
    val price = service.price
}
