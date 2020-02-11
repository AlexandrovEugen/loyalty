package com.evg.service

import com.evg.aspect.Log
import com.evg.entity.User
import com.evg.repository.UserRepository
import com.evg.exception.EntityNotFoundException
import org.springframework.stereotype.Service

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

    fun deleteUser(email: String): User {
        val user =
            userRepository.findByEmail(email) ?: throw EntityNotFoundException("There is no user with email: $email")
        userRepository.delete(user)
        return user
    }
}
