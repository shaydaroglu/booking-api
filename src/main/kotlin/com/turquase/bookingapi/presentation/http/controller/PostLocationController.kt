package com.turquase.bookingapi.presentation.http.controller

import com.cloudogu.cb.CommandBus
import com.turquase.bookingapi.domain.locations.command.CreateLocation
import com.turquase.bookingapi.presentation.http.response.GetLocationResponse
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class PostLocationController(private val handler: CommandBus) {
    @PostMapping(
        value = ["/locations"],
        produces = ["application/json"]
    )
    @Operation(
        summary = "Create a Booking Location",
        description = "Create location based on data in the body",
        tags = ["locations"]
    )
    @ResponseStatus(HttpStatus.CREATED)
    operator fun invoke(@RequestBody command: CreateLocation): GetLocationResponse {
        val location = handler.execute(command)

        return GetLocationResponse(location)
    }
}