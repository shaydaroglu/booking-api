package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.users.entity.UserEntity
import com.turquase.bookingapi.domain.users.repository.UsersRepository
import org.springframework.stereotype.Component
import javax.persistence.NoResultException

@Component
class MySqlUsersRepository(
    private val jpaUsersRepository: JpaUsersRepository
) : AbstractMySqlRepository(), UsersRepository {
    override fun save(user: UserEntity) {
        jpaUsersRepository.save(user)
    }

    override fun persistAll(users: Iterable<UserEntity>) {
        users.forEach { manager.persist(it) }
    }

    override fun findOneById(id: Long): UserEntity? {
        val sqlQuery = """
            |SELECT user 
            |FROM UsersEntity as user 
            |WHERE user.id = :id""".trimMargin()

        return try {
            manager.createQuery(sqlQuery, UserEntity::class.java)
                .setParameter("id", id).singleResult
        } catch (ex: NoResultException) {
            null
        }
    }
}
