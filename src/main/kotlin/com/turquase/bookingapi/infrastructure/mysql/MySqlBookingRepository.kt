package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.booking.entity.BookingEntity
import com.turquase.bookingapi.domain.booking.repository.BookingRepository
import org.springframework.stereotype.Component
import javax.persistence.NoResultException

@Component
class MySqlBookingRepository(
    private val jpa: JpaBookingRepository
) : AbstractMySqlRepository(), BookingRepository {
    override fun save(booking: BookingEntity) {
        jpa.save(booking)
    }

    override fun persistAll(bookings: Iterable<BookingEntity>) {
        bookings.forEach { manager.persist(it) }
    }

    override fun findOneById(id: Long): BookingEntity? {
        val sqlQuery = "SELECT booking FROM BookingEntity as booking WHERE booking.id = :id"

        return try {
            manager.createQuery(sqlQuery, BookingEntity::class.java)
                .setParameter("id", id).singleResult
        } catch (ex: NoResultException) {
            null
        }
    }
}
