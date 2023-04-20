package com.turquase.bookingapi.infrastructure.mysql

import com.turquase.bookingapi.domain.users.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaUsersRepository : JpaRepository<UserEntity, Long>
