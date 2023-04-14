package com.turquase.bookingapi.application.service

import java.util.UUID

object RequestIdStore {
    private var requestId: String? = null

    fun get(): String? {
        if (requestId == null) {
            init()
        }

        return requestId
    }

    fun set(requestId: String?) {
        this.requestId = requestId
    }

    fun clear() {
        this.requestId = null
    }

    private fun init() {
        this.requestId = UUID.randomUUID().toString()
    }
}
