package com.evg.repository

import com.evg.entity.User
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long> {

    fun findByEmail(login: String): User?
}