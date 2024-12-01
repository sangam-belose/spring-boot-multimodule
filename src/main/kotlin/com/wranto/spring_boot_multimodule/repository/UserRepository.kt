package com.wranto.spring_boot_multimodule.repository

import com.wranto.spring_boot_multimodule.repository.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>