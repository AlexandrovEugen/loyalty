package com.evg.facade

import com.evg.aspect.Log
import com.evg.dto.UserDto
import com.evg.service.UserService
import org.springframework.stereotype.Component

@Component
class UserFacade(private val userService: UserService) {

    @Log
    fun signUpUser(userDto: UserDto) = userService.createUser(userDto.toUser())

    @Log
    fun getUsers(): List<UserDto> = userService.getUsers().map { it.toUserDto() }

    fun deleteUser(email: String) = userService.deleteUser(email)

}