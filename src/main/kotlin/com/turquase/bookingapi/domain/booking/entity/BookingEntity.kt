package com.turquase.bookingapi.domain.booking.entity

import com.turquase.bookingapi.domain.common.WithTimeStamp
import com.turquase.bookingapi.domain.locations.entity.LocationEntity
import com.turquase.bookingapi.domain.services.entity.ServiceEntity
import com.turquase.bookingapi.domain.users.entity.UserEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "bookings")
class BookingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    var service: ServiceEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    var location: LocationEntity? = null,

    @Column(name = "start_time")
    var startTime: LocalDateTime? = null,

    @Column(name = "end_time")
    var endTime: LocalDateTime? = null,

    @Column(name = "status")
    var status: String? = null
) : WithTimeStamp()
