package com.wranto.spring_boot_multimodule.service

import com.wranto.spring_boot_multimodule.repository.UserRepository
import com.wranto.spring_boot_multimodule.repository.entity.User
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User = userRepository.findById(id).orElseThrow {
        NoSuchElementException("User with id $id not found")
    }
}