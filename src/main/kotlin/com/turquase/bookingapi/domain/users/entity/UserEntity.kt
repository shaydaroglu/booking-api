package com.turquase.bookingapi.domain.users.entity

import com.turquase.bookingapi.domain.common.WithTimeStamp
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,
) : WithTimeStamp() {
    @Transient
    private val encoder = BCryptPasswordEncoder()

    @JvmName("functionOfKotlin")
    fun setPassword(password: String) {
        this.password = encoder.encode(password)
    }
}
