package com.sample.study.concurrency

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class RaceCondition {

}

data class UserTest(
    val name: String,
    val age: Int,
)

var user: UserTest? = null;

fun main() = runBlocking {
    asyncGetUserInfo(id = 1)
    delay(3000)

    println("User Info Name : ${user?.name} Age : ${user?.age}")
}

fun asyncGetUserInfo(id: Int) = GlobalScope.async {
    delay(1000)
    user = UserTest(name = "UserTest", age = 23)
}