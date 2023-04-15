package com.turquase.bookingapi.domain.locations.entity

import com.turquase.bookingapi.domain.common.WithTimeStamp
import javax.persistence.*

@Entity
@Table(name = "locations")
class LocationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "address")
    var address: String,

    @Column(name = "city")
    var city: String,

    @Column(name = "country")
    var country: String,

    @Column(name = "latitude")
    var latitude: Double,

    @Column(name = "longitude")
    var longitude: Double
) : WithTimeStamp()
