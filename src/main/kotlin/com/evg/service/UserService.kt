package com.evg.service

import com.evg.aspect.Log
import com.evg.entity.User
import com.evg.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    @Log
    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    @Log
    fun getUsers(): List<User> {
        return userRepository.findAll().toList()
    }

}
