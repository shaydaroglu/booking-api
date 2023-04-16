package com.turquase.bookingapi.domain.services.entity

import com.turquase.bookingapi.domain.common.WithTimeStamp
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "services")
class ServiceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "price")
    var price: BigDecimal,
) : WithTimeStamp()
