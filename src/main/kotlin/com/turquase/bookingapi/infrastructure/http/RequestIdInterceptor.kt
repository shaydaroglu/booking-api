package com.turquase.bookingapi.infrastructure.http

import com.turquase.bookingapi.application.service.RequestIdStore
import com.turquase.bookingapi.presentation.http.filter.RequestIdFilter
import org.apache.http.HttpRequest
import org.apache.http.HttpRequestInterceptor
import org.apache.http.protocol.HttpContext

class RequestIdInterceptor : HttpRequestInterceptor {
    override fun process(request: HttpRequest, context: HttpContext) {
        request.addHeader(RequestIdFilter.REQUEST_ID_HEADER, RequestIdStore.get())
    }
}
