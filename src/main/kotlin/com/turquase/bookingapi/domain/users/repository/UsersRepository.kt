package com.turquase.bookingapi.domain.users.repository

import com.turquase.bookingapi.domain.users.entity.UserEntity

interface UsersRepository {
    fun save(user: UserEntity)
    fun persistAll(users: Iterable<UserEntity>)
    fun findOneById(id: Long): UserEntity?
}
