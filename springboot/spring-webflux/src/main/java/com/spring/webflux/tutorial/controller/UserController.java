package com.spring.webflux.tutorial.controller;


// Annotation-based Components

import com.spring.webflux.tutorial.domain.User;
import com.spring.webflux.tutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    // Spring MVC 와 똑같아 보이지만
    // 가장 큰 차이점은 Spring MVC 와 Spring Webflux 는 Request 와 Response 를
    // 다루는 방법과 Non-blocking publishers 인 Mono 와 Flux 를 사용한다.
    // Subscribe Method Controller 에서 부를 필요는 없다.
    // 내부적인 Class 들이 가능할 떄에 부를 것이다.

    // Spring Reactive Pattern 을 구성할 때 가장 중요한 점은 Do Not Block 이다 !!!
    // We must make sure that we don't use any blocking methods throughout the lifecycle of an API.
    // Otherwise, we lose the main advantage of reactive programming.

    // Spring WebFlux 를 사용 시 2가지 방법 중 1가지를 선택할 수 있다
    // 1. Controller 에서 직접 Mono or Flux 로 Return
    // 2. Handler 를 사용하여 Return

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

    // Server Side Event would have the content type text/event-stream, can define simply Server Side
    // Event streaming using WebFlux by simply returning Flux
    // Stream all the users in our system every 2 seconds, This serves the whole list of updated users from the MongoDB every interval.
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamAllUsers() {
        return userService
                .getAllUsers()
                .flatMap(user -> Flux
                        .zip(Flux.interval(Duration.ofSeconds(2)),
                             Flux.fromStream(Stream.generate(() -> user))
                ).map(Tuple2::getT2)
                );
    }

}
