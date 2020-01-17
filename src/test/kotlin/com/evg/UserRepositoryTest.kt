package com.evg

import com.evg.entity.User
import com.evg.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class UserRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository
) {

    @Test
    fun `When findByLogin then return User`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()
        val foundUser = userRepository.findByLogin(juergen.login)
        assertThat(foundUser).isNotNull
        assertThat(foundUser).isEqualTo(juergen)

        foundUser?.let { userRepository.delete(it) }

        val deletedUser = userRepository.findByLogin(juergen.login)

        assertThat(deletedUser).isNull()
    }
}