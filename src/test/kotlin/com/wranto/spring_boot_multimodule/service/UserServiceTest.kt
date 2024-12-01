package com.wranto.spring_boot_multimodule.service

import com.wranto.spring_boot_multimodule.repository.UserRepository
import com.wranto.spring_boot_multimodule.repository.entity.User
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class UserServiceTest {

    @MockK private lateinit var userRepository: UserRepository
    private lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        userService = UserService(userRepository)
    }

    @Test
    fun `getUserById should return user when user exists`() {
        val user = User(id = 1L, name = "dummy", email ="dummy@dummy.com")

        every { userRepository.findById(any()) } returns Optional.of(user)

        val result = userService.getUserById(1L)
        assertEquals(user, result)
    }

    @Test
    fun `getUserById should return errorMessage when user doesnt exists`() {
        every { userRepository.findById(any()) } returns Optional.empty()

        val exception = assertThrows<NoSuchElementException> {
            userService.getUserById(2L)
        }

        assertEquals("User with id 2 not found", exception.message)
    }

    @Test
    fun `getAllUsers should return all users when exists`() {
        val users = listOf<User>(
            User(1L, "dummy", "dummy@dummy.com"),
            User(2L, "sunny", "sunny@sunny.com")
        )

        every { userRepository.findAll() } returns users

        val result = userService.getAllUsers()
        assertEquals(users, result)
    }

    @Test
    fun `getAllUsers should return empty list if no users exists`() {
        every { userRepository.findAll() } returns mutableListOf()
        val result = userService.getAllUsers()
        assertEquals(0, result.size)
    }
}