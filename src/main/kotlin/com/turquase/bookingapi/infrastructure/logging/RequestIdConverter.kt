package com.turquase.bookingapi.infrastructure.logging

import com.turquase.bookingapi.application.service.RequestIdStore
import ch.qos.logback.classic.pattern.ClassicConverter
import ch.qos.logback.classic.spi.ILoggingEvent

class RequestIdConverter : ClassicConverter() {
    override fun convert(event: ILoggingEvent?): String {
        return RequestIdStore.get().toString()
    }
}
