package com.turquase.bookingapi.presentation.http.filter

import com.turquase.bookingapi.application.service.RequestIdStore
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
class RequestIdFilter : OncePerRequestFilter() {
    companion object {
        const val REQUEST_ID_HEADER = "X-Request-Id"
    }

    override fun doFilterInternal(
        servletRequest: HttpServletRequest,
        servletResponse: HttpServletResponse,
        chain: FilterChain
    ) {
        try {
            RequestIdStore.set(servletRequest.getHeader(REQUEST_ID_HEADER))
            chain.doFilter(servletRequest, servletResponse)
        } finally {
            RequestIdStore.clear()
        }
    }
}
