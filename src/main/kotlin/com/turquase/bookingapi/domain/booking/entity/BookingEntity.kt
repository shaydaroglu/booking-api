package com.turquase.bookingapi.domain.booking.entity

import com.turquase.bookingapi.domain.common.WithTimeStamp
import com.turquase.bookingapi.domain.locations.country.entity.LocationEntity
import com.turquase.bookingapi.domain.services.entity.ServiceEntity
import com.turquase.bookingapi.domain.users.entity.UserEntity
import org.joda.time.LocalDateTime
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "bookings")
class BookingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    var service: ServiceEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    var location: LocationEntity,

    @Column(name = "start_time")
    var startTime: LocalDateTime,

    @Column(name = "end_time")
    var endTime: LocalDateTime,

    @Column(name = "status")
    var status: String,

    @Column(name = "price")
    var price: BigDecimal,
) : WithTimeStamp()
