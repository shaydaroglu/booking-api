package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.reviews.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaReviewsRepository : JpaRepository<ReviewEntity, Long>
