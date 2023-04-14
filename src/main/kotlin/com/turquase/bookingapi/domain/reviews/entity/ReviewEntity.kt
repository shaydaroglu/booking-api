package com.turquase.bookingapi.domain.reviews.entity

import com.turquase.bookingapi.domain.common.WithTimeStamp
import javax.persistence.*

@Entity
@Table(name = "reviews")
class ReviewEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "user_id")
    var userId: Long,

    @Column(name = "service_id")
    var serviceId: Long,

    @Column(name = "location_id")
    var locationId: Long,

    @Column(name = "rating")
    var rating: Int,

    @Column(name = "comment")
    var comment: String? = null,
) : WithTimeStamp()
