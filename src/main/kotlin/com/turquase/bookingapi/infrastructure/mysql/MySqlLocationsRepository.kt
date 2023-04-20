package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.locations.entity.LocationEntity
import com.turquase.bookingapi.domain.locations.repository.LocationsRepository
import org.springframework.stereotype.Component
import javax.persistence.NoResultException

@Component
class MySqlLocationsRepository(
    private val jpaLocationsRepository: JpaLocationsRepository
) : AbstractMySqlRepository(), LocationsRepository {
    override fun save(location: LocationEntity) {
        jpaLocationsRepository.save(location)
    }

    override fun persistAll(users: Iterable<LocationEntity>) {
        users.forEach { manager.persist(it) }
    }

    override fun findOneById(id: Long): LocationEntity? {
        val sqlQuery = """
            |SELECT location 
            |FROM LocationEntity as location 
            |WHERE location.id = :id""".trimMargin()

        return try {
            manager.createQuery(sqlQuery, LocationEntity::class.java)
                .setParameter("id", id).singleResult
        } catch (ex: NoResultException) {
            null
        }
    }
}
