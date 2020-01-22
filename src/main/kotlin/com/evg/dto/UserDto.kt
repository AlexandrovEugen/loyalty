package com.evg.dto

import com.evg.entity.User
import javax.validation.constraints.Email

data class UserDto(
    val id: Long? = null,
    @Email val email: String,
    val firstName: String,
    val lastName: String,
    val description: String? = null
) {

    fun toUser() = User(this.email, this.firstName, this.lastName, this.description)

}
