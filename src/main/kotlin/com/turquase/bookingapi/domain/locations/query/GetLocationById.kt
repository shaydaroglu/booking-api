package com.turquase.bookingapi.domain.locations.query

import com.turquase.bookingapi.domain.common.Query
import com.turquase.bookingapi.domain.locations.entity.LocationEntity
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotEmpty

class GetLocationById(
    @field: NotEmpty(message = "Location ID must not be blank")
    @field: Parameter(
        `in` = ParameterIn.PATH,
        description = "Id of the location",
        schema = Schema(type = "string")
    )
    private val id: String
) : Query<LocationEntity> {
    fun getId(): Long {
        return id.toLong()
    }
}
