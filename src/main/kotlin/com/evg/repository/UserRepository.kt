package com.evg.repository

import com.evg.aspect.Log
import com.evg.entity.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long> {

    @Log
    fun findByEmail(login: String): User?
}