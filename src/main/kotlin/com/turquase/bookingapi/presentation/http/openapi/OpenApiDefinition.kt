package com.turquase.bookingapi.presentation.http.openapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "Booking Service Sample API",
        description = "A service as showcase for making booking online.",
        contact = Contact(name = "Sercan Haydaroglu"),
        version = "1.0"
    )
)
class OpenApiDefinition
