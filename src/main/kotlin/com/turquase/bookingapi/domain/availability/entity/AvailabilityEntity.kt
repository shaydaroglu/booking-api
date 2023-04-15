package com.turquase.bookingapi.domain.availability.entity

import com.turquase.bookingapi.domain.common.WithTimeStamp
import org.joda.time.LocalDate
import org.joda.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "availability")
class AvailabilityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "service_id")
    var serviceId: Long,

    @Column(name = "location_id")
    var locationId: Long,

    @Column(name = "date")
    var date: LocalDate,

    @Column(name = "start_time")
    var startTime: LocalDateTime,

    @Column(name = "end_time")
    var endTime: LocalDateTime,
) : WithTimeStamp()
