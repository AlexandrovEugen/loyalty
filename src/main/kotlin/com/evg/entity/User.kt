package com.evg.entity

import com.evg.dto.UserDto
import javax.persistence.*

@Entity
data class User(
    @Column(unique = true) val email: String,
    val firstName: String,
    val lastName: String,
    val password: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
) {

    fun toUserDto() = UserDto(this.id, this.email, this.firstName, this.lastName, this.password)
}


