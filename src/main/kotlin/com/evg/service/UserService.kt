package com.evg.service

import com.evg.aspect.Log
import com.evg.entity.User
import com.evg.repository.UserRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    @Log
    @CachePut("users", key = "#user.firstName")
    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    @Log
    @Cacheable("users")
    fun getUsers(): List<User> {
        return userRepository.findAll().toList()
    }

    @Log
    @CacheEvict("users", key = "#email")
    fun deleteUser(email: String) {
        val user = userRepository.findByEmail(email)
        user?.let {
            userRepository.delete(user)
        }
    }
}
