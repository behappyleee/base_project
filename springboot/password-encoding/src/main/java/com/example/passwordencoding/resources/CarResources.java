package com.example.passwordencoding.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CarResources {

    Logger logger = LoggerFactory.getLogger(CarResources.class);

    @GetMapping("/cars")
    public Set<Car> cars() {
        Set<Car> cars = Set.of(new Car("vm", "black"), new Car("bmw", "white"));

        logger.info("CARS DATA CHECK : {} ", cars);
        return cars;
    }

}
