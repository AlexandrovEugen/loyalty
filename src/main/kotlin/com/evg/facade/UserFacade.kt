package com.evg.facade

import com.evg.dto.UserDto
import com.evg.entity.User
import com.evg.service.UserService
import org.springframework.stereotype.Component

@Component
class UserFacade(private val userService: UserService) {

    fun signUpUser(userDto: UserDto): User {
        return userService.createUser(userDto.toUser())
    }

    fun getUsers(): List<UserDto> {
        return userService.getUsers().map { it.toUserDto() }
    }
}