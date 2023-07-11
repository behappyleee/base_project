package com.docker.springbootdocker.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @RequestMapping("/docker/hello")
    public String dockerHello() {
        return "THIS IS SPRING DOCKER PROJECT TEST !!";
    }

}
