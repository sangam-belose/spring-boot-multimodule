package com.wranto.spring_boot_multimodule.integrationTest.service

import com.wranto.spring_boot_multimodule.integrationTest.AbstractIntegrationTest
import com.wranto.spring_boot_multimodule.repository.UserRepository
import com.wranto.spring_boot_multimodule.repository.entity.User
import com.wranto.spring_boot_multimodule.service.UserService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertEquals

@SpringBootTest
@Profile("integration")
class UserServiceIT : AbstractIntegrationTest() {

    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        userRepository.deleteAll()
        userRepository.saveAll(
            listOf(
                User(name = "Sangam", email = "sangam@sangam.com", ),
                User(name = "Shraddha", email = "shraddha@sangam.com", )
            )
        )
    }

    @Test
    fun `getAllUsers should return all users from database`() {
        val result = userService.getAllUsers()

        assertEquals(2, result.size)
        assertEquals("Sangam", result[0].name)
        assertEquals("shraddha@sangam.com", result[1].email)
    }

    @Test
    fun `getUserById should return user with given ID`() {
        val result = userService.getUserById(2L)
        assertEquals(2L, result.id)
        assertEquals("Shraddha", result.name)
        assertEquals("shraddha@sangam.com", result.email)
    }

    @Test
    fun `getUserById should throw exception if user doesn't exist`() {
        val exception = assertThrows<NoSuchElementException> {
            userService.getUserById(9999L)
        }
        assertEquals("User with id 9999 not found", exception.message)
    }

}