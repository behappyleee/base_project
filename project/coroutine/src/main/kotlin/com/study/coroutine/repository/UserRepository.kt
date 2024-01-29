package com.study.coroutine.repository

import com.study.coroutine.model.UserTest
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserTest, Long>