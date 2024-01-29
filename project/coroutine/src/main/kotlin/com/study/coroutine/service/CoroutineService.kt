package com.study.coroutine.service

import com.study.coroutine.model.UserTest
import com.study.coroutine.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class CoroutineService(
    private val userRepository: UserRepository,
) {

    fun findUserById(
        id: Long
    ): UserTest? = userRepository.findById(id).orElse(null)

    // Implement a service using coroutines to handle asynchronous operations
    suspend fun getAsyncData(): String = withContext(Dispatchers.IO) {
        delay(1000)

        "Data retrieved asynchronously"
    }
}


fun main() {
    val testInt = 7
    when(testInt) {
        3 -> println("THIS IS 3 !")
        5 -> println("THIS IS 5 !!")
        7 -> {
            val aaa = 777
            println(aaa)
        }
        else -> throw IllegalArgumentException("This is illegal exception !!")
    }

}