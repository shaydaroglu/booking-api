package com.turquase.bookingapi

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.AssertionErrors.assertTrue

@SpringBootTest
class ApplicationTests {

    @Test
    fun contextLoads() {
        assertTrue("Context loads", true)
    }
}
