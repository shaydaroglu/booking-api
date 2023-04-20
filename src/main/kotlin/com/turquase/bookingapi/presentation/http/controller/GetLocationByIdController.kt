package com.turquase.bookingapi.presentation.http.controller

import com.cloudogu.cb.CommandBus
import com.turquase.bookingapi.domain.locations.query.GetLocationById
import com.turquase.bookingapi.presentation.http.response.GetLocationResponse
import io.swagger.v3.oas.annotations.Operation
import org.springdoc.api.annotations.ParameterObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetLocationByIdController(private val handler: CommandBus) {

    @GetMapping(
        value = ["/locations/{id}"],
        produces = ["application/json"]
    )
    @Operation(
        summary = "Get location by id",
        description = "Retrieve an Location based on internal id",
        tags = ["locations"]
    )
    operator fun invoke(
        @ParameterObject
        @PathVariable("id")
        query: GetLocationById
    ): GetLocationResponse {
        val location = handler.execute(query)

        return GetLocationResponse(location)
    }

}
