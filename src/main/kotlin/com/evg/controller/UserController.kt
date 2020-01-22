package com.evg.controller

import com.evg.aspect.Log
import com.evg.dto.UserDto
import com.evg.entity.User
import com.evg.facade.UserFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("/user")
class UserController(@Autowired val userFacade: UserFacade) {


    @Log
    @PostMapping("/sign-up")
    fun createUser(@RequestBody user: UserDto): ResponseEntity<User> = ResponseEntity.ok(userFacade.signUpUser(user))

    @Log
    @GetMapping("all")
    fun getUsers(): ResponseEntity<List<UserDto>> = ResponseEntity.ok(userFacade.getUsers())

    @Log
    @DeleteMapping("delete")
    fun deleteUser(@RequestParam email: String) = ResponseEntity.ok(userFacade.deleteUser(email))
}