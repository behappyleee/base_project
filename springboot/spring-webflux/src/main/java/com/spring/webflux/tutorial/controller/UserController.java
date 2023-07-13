package com.spring.webflux.tutorial.controller;


// Annotation-based Components

import com.spring.webflux.tutorial.domain.User;
import com.spring.webflux.tutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    // Spring MVC 와 똑같아 보이지만
    // 가장 큰 차이점은 Spring MVC 와 Spring Webflux 는 Request 와 Response 를
    // 다루는 방법과 Non-blocking publishers 인 Mono 와 Flux 를 사용한다.
    // Subscribe Method Controller 에서 부를 필요는 없다.
    // 내부적인 Class 들이 가능할 떄에 부를 것이다.
    //


    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public Flux<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable String userId){
        Mono<User> user = userService.findById(userId);
        return user.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public Mono<ResponseEntity<User>> updateUserById(@PathVariable String userId, @RequestBody User user){
        return userService.updateUser(userId,user)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{userId}")
    public Mono<ResponseEntity<Void>> deleteUserById(@PathVariable String userId){
        return userService.deleteUser(userId)
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public Flux<User> searchUsers(@RequestParam("name") String name) {
        return userService.fetchUsers(name);
    }

}
