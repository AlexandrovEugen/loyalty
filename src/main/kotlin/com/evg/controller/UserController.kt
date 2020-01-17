package com.evg.controller

import com.evg.dto.UserDto
import com.evg.entity.User
import com.evg.facade.UserFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/user")
class UserController(@Autowired val userFacade: UserFacade) {


    @PostMapping("/sign-up")
    fun signUp(@RequestBody user: UserDto): ResponseEntity<User> = ResponseEntity.ok(userFacade.signUpUser(user))

    @GetMapping("all")
    fun getUsers(): ResponseEntity<List<UserDto>> = ResponseEntity.ok(userFacade.getUsers())

}