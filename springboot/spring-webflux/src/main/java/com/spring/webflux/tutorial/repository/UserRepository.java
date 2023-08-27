package com.spring.webflux.tutorial.repository;

import com.spring.webflux.tutorial.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    // Persistence Layer - Defining Repositories


}
