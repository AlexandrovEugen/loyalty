package com.evg.entity

import com.evg.dto.UserDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    val login: String,
    val firstName: String,
    val lastName: String,
    val description: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
) {

    fun toUserDto() = UserDto(this.login, this.firstName, this.lastName, this.description)
}


