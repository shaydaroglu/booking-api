package com.turquase.bookingapi.domain.locations.command

import com.cloudogu.cb.Command
import com.turquase.bookingapi.domain.locations.entity.LocationEntity
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.lang.Nullable
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateLocation(
    @field: Nullable
    private val id: Long? = null,
    @field: NotEmpty(message = "Location name can not be empty")
    @Schema(description = "Name of the Location", example = "Turquase Hotel")
    val name: String? = null,
    @field: NotEmpty(message = "Location's address can not be empty")
    @Schema(description = "Address of location", example = "Bodestraße 1")
    val address: String? = null,
    @field: NotEmpty(message = "Location's city can not be empty")
    @Schema(description = "City of location", example = "Berlin")
    val city: String? = null,
    @field: NotEmpty(message = "Location's country can not be empty")
    @Schema(description = "Country of location", example = "Germany")
    val country: String? = null,
    @Schema(description = "State of location", example = "Berlin")
    val state: String? = null,
    @field: NotNull(message = "Location latitude can not be empty")
    @Schema(description = "Latitude of location")
    val latitude: Double? = null,
    @field: NotNull(message = "Location longitude can not be empty")
    @Schema(description = "Longitude of location")
    val longitude: Double? = null
) : Command<LocationEntity>