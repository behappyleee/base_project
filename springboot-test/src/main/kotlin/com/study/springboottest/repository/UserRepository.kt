package com.study.springboottest.repository

import com.study.springboottest.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Long> {

    fun findUserByEmail(email: String): Optional<User>

}