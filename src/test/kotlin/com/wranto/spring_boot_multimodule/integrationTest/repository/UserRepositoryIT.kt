package com.wranto.spring_boot_multimodule.integrationTest.repository

import com.wranto.spring_boot_multimodule.integrationTest.AbstractIntegrationTest
import com.wranto.spring_boot_multimodule.repository.UserRepository
import com.wranto.spring_boot_multimodule.repository.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryIT: AbstractIntegrationTest() {

    @Autowired private lateinit var userRepository: UserRepository

    @BeforeEach
    fun setup() {
        userRepository.saveAll(
            listOf(
                User(name = "Sangam", email = "sangam@sangam.com"),
                User(name = "Shraddha", email="shraddha@sangam.com")
            )
        )
    }

    @Test
    fun `connection is established`() {
        assertThat(postgresContainer.isCreated).isTrue()
        assertThat(postgresContainer.isRunning).isTrue()
    }

    @Test
    fun `findById should return user with given id`() {
        val user = userRepository.findById(1);
        assertThat(user).isNotNull
    }
}