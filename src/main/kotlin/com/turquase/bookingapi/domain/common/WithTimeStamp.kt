package com.turquase.bookingapi.domain.common

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import javax.persistence.MappedSuperclass
import javax.persistence.PreUpdate

private const val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"

@MappedSuperclass
abstract class WithTimeStamp(
    @JsonFormat(pattern = DATE_FORMAT)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @JsonFormat(pattern = DATE_FORMAT)
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {

    @PreUpdate
    fun onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}
