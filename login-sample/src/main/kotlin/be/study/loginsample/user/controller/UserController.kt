package be.study.loginsample.user.controller

import be.study.loginsample.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {
    @GetMapping("/users/{id}")
    fun getUser(
        @PathVariable("id") id: String
    ) {

    }
}
