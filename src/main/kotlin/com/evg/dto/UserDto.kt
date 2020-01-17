package com.evg.dto

import com.evg.entity.User

data class UserDto(val login: String, val firstName: String, val lastName: String, val description: String? = null) {

    fun toUser() = User(this.login, this.firstName, this.lastName, this.description)

}
